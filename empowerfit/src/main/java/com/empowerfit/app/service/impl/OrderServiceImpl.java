package com.empowerfit.app.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Order;
import com.empowerfit.app.repository.OrderRepository;
import com.empowerfit.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
 
    
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        order.setId(null); // Aseguramos que sea una nueva orden
        order.setPurchaseDate(LocalDate.now());
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("No existe una orden con id " + id));
    }

    @Override
    public List<Order> getOrdersByPurchaseDate(LocalDate purchaseDate) {
        return orderRepository.findByPurchaseDate(purchaseDate);
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByPurchaseDateBetween(startDate, endDate);
    }

    @Override
    public Set<Order> getOrdersByMinAmount(Double minAmount) {
        return orderRepository.findByTotalAmountGreaterThanEqual(minAmount);
    }
    
    @Override
    public Order updateOrder(Order order, Long id) {
        Order existingOrder = getOrderById(id);
        existingOrder.setStatus(order.getStatus());
        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        orderRepository.delete(existingOrder);
    }

	 @Override
	 public List<Order> getAllOrders() {
	 List<Order> orders = new ArrayList<>();
	 orderRepository.findAll().forEach(orders::add); // Convertimos Iterable a List
	 return orders;
	 }
}

