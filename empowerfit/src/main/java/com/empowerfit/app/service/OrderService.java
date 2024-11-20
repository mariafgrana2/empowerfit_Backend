package com.empowerfit.app.service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.empowerfit.app.model.Order;

public interface OrderService {
	    // Crea una nueva orden en el sistema.
	    Order createOrder(Order order);

	    // Obtiene una orden por su ID.
	    Order getOrderById(Long id);

	    // Obtiene todas las órdenes realizadas por un cliente específico.
	    //List<Order> getOrdersByUserId(Long userId);

	    // Obtiene todas las órdenes realizadas en una fecha específica.
	    List<Order> getOrdersByOrderDate(LocalDateTime orderDate);

	    // Obtiene todas las órdenes realizadas en un rango de fechas.
	     
	    List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate);

	    // Obtiene todas las órdenes cuyo monto total es mayor o igual a un valor específico.
	    Set<Order> getOrdersByMinAmount(Double minAmount);
	    
	    List<Order> getAllOrders();

	    // Actualiza la información de una orden existente.
	    Order updateOrder(Order order, Long id);

	    //Elimina una orden por su ID.
	    void deleteOrder(Long id);
}
