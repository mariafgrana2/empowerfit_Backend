package com.empowerfit.app.repository;

import com.empowerfit.app.model.ShopBag;
import com.empowerfit.app.model.ShopBagKey;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;


public interface ShopBagRepository extends CrudRepository<ShopBag, ShopBagKey> {

	//Busca todas las bolsas de compras asociadas a un pedido específico.
	List<ShopBag> findById_OrderId(Long orderId);
	
	// Busca todas las bolsas de compras creadas en una fecha específica.
	List<ShopBag> findById_Date(LocalDate date);

}