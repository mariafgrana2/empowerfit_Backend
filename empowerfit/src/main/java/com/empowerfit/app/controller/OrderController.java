package com.empowerfit.app.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empowerfit.app.model.Order;
import com.empowerfit.app.service.OrderService;

@CrossOrigin(origins = "*")
@Controller
@ResponseBody
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping // http://localhost:8080/api/v1/orders
    ResponseEntity<Order> createOrder(@RequestBody Order newOrder) {
        Order createdOrder = orderService.createOrder(newOrder);
        return ResponseEntity.status(201).body(createdOrder);
    }

    @GetMapping("{id}") // http://localhost:8080/api/v1/orders/{id}
    Order getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/by") // http://localhost:8080/api/v1/orders/by?date={date}
    List<Order> getOrdersByPurchaseDate(@RequestParam("date") LocalDate date) {
        return orderService.getOrdersByPurchaseDate(date);
    }

    @GetMapping("/range") // http://localhost:8080/api/v1/orders/range?start={startDate}&end={endDate}
    List<Order> getOrdersByDateRange(@RequestParam("start") LocalDate startDate, @RequestParam("end") LocalDate endDate) {
        return orderService.getOrdersByDateRange(startDate, endDate);
    }

    @GetMapping("/amount") // http://localhost:8080/api/v1/orders/amount?min={minAmount}
    Set<Order> getOrdersByMinAmount(@RequestParam("min") Double minAmount) {
        return orderService.getOrdersByMinAmount(minAmount);
    }

    @PutMapping("{id}") // http://localhost:8080/api/v1/orders/{id}
    ResponseEntity<Order> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        Order updatedOrder = orderService.updateOrder(order, id);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("{id}") // http://localhost:8080/api/v1/orders/{id}
    ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Orden con id " + id + " ha sido eliminada");
    }
}

