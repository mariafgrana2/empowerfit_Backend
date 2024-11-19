package com.empowerfit.app.service;


import java.time.LocalDate;
import java.util.List;
import com.empowerfit.app.model.ShopBag;

public interface ShopBagService {

	ShopBag createShopBag(ShopBag shopBag);
	
	List<ShopBag> getShopBagsByOrderId(Long orderId);
	List<ShopBag> getAllShopBags();
	List<ShopBag> getShopBagsByDate(LocalDate date);
	
	void updateShopBagsForOrder(List<ShopBag> shopBags, Long orderId);
	void deleteShopBagsByOrderId(Long orderId);

}
