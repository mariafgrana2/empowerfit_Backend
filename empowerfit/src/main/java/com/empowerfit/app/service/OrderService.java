package com.empowerfit.app.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.empowerfit.app.model.Order;

public interface OrderService {
	    // Crea una nueva orden en el sistema.
	    Order createOrder(Order order);

	    // Obtiene una orden por su ID.
	    Order getOrderById(Long id);

	    // Obtiene todas las órdenes realizadas por un cliente específico.
	    List<Order> getOrdersByCustomerId(Long customerId);

	    // Obtiene todas las órdenes realizadas en una fecha específica.
	    List<Order> getOrdersByPurchaseDate(LocalDate purchaseDate);

	    // Obtiene todas las órdenes realizadas en un rango de fechas.
	     
	    List<Order> getOrdersByDateRange(LocalDate startDate, LocalDate endDate);

	    // Obtiene todas las órdenes cuyo monto total es mayor o igual a un valor específico.
	    Set<Order> getOrdersByMinAmount(Double minAmount);

	    // Obtiene todas las órdenes cuyo monto total es menor a un valor específico.
	    Set<Order> getOrdersByMaxAmount(Double maxAmount);

	    // Actualiza la información de una orden existente.
	    Order updateOrder(Order order, Long id);

	    //Elimina una orden por su ID.
	    void deleteOrder(Long id);
}
