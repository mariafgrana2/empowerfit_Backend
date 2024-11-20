package com.empowerfit.app.repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.empowerfit.app.model.Order;



@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends CrudRepository<Order, Long> {
	//Encuentra todas las órdenes realizadas por un cliente usando su ID.
	 
    // List<Order> findByUserId(Long userId);

    List<Order> findByOrderDate(LocalDateTime orderDate);

    //Encuentra todas las órdenes realizadas entre dos fechas específicas.
    List<Order> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    //Encuentra una orden específica usando su ID.
    Order findById(long id);

    //Encuentra todas las órdenes cuyo monto total sea mayor o igual a un valor específico.
    Set<Order> findByTotalAmountGreaterThanEqual(Double minAmount);
}
	    
	    
	    

