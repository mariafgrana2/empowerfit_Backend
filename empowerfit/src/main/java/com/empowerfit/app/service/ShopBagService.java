package com.empowerfit.app.service;

import java.util.Date;
import java.util.List;
import com.empowerfit.app.model.ShopBag;

public interface ShopBagService {

	ShopBag createShopBag(ShopBag shopBag);
	ShopBag getShopBagById(Long id);
	List<ShopBag> getShopBagsByDate(Date date);
	List<ShopBag> getShopBagsByDateRange(Date startDate, Date endDate);
	ShopBag updateShopBag(ShopBag shopBag, Long id);
	void deleteShopBag(Long id);

}
