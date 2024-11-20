package com.empowerfit.app.repository;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.empowerfit.app.model.OrderHasProduct;
import com.empowerfit.app.model.composite_key.OrderProductKey;


@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ordersHasProducts", path = "ordersHasProducts")
public interface OrderHasProductRepository extends CrudRepository<OrderHasProduct, OrderProductKey> {

		Set<OrderHasProduct> findAllByOrderId(@Param("order") Long orderId );
		Set<OrderHasProduct> findAllByOrderOrderDate(@Param("order-date") LocalDateTime orderDate );
		void deleteByOrderIdAndProductId(@Param("order") Long orderId, @Param("product") Long productId);
		
}
