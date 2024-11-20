package com.empowerfit.app.service;

import java.util.Set;

import com.empowerfit.app.model.OrderHasProduct;

public interface OrderHasProductService {
	OrderHasProduct createOrderHasProduct(OrderHasProduct orderHasProduct);
	Set<OrderHasProduct> getOrderHasProducts();	
	OrderHasProduct getOrderHasProductByCompositeId(Long orderId, Long productId);	
	Set<OrderHasProduct> getOrderHasProductsByOrderId(Long orderId);		
	OrderHasProduct updateOrderHasProductByCompositeId(OrderHasProduct orderHasProduct, long orderId, long productId);
	void deleteOrderHasProductByCompositeId(Long orderId, Long productId);
}
