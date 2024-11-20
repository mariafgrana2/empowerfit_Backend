package com.empowerfit.app.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.OrderHasProduct;
import com.empowerfit.app.model.composite_key.OrderProductKey;
import com.empowerfit.app.repository.OrderHasProductRepository;
import com.empowerfit.app.service.OrderHasProductService;

@Service
public class OrderHasProductServiceImpl implements OrderHasProductService{
	
	OrderHasProductRepository orHprRepository;
	
	public OrderHasProductServiceImpl(OrderHasProductRepository orHprRepository) {
		this.orHprRepository = orHprRepository;
	}

	@Override
	public OrderHasProduct createOrderHasProduct(OrderHasProduct orderHasProduct) {
		return orHprRepository.save( orderHasProduct );
	}

	@Override
	public Set<OrderHasProduct> getOrderHasProducts() {
		return (Set<OrderHasProduct>) orHprRepository.findAll();
	}

	@Override
	public OrderHasProduct getOrderHasProductByCompositeId(Long orderId, Long productId) {
		OrderProductKey purchaseProductKey = new OrderProductKey(orderId, productId);
		Optional<OrderHasProduct> optionalPuHpr = orHprRepository.findById(purchaseProductKey);
		if( optionalPuHpr.isEmpty()) {
			new IllegalStateException (
					"OrderHasProduct does not exist with order Id: " +
			orderId + " and product Id " + productId);
		}
		return optionalPuHpr.get();
	}

	@Override
	public Set<OrderHasProduct> getOrderHasProductsByOrderId(Long orderId) {
		return orHprRepository.findAllByOrderId(orderId);
	}

	@Override
	public OrderHasProduct updateOrderHasProductByCompositeId(OrderHasProduct orderHasProduct,
			long purchaseId, long productId) {
		OrderHasProduct existingOrHpr = getOrderHasProductByCompositeId(purchaseId, productId);
		existingOrHpr.setOrderSold( orderHasProduct.getOrderSold() );
		existingOrHpr.setQuantity( orderHasProduct.getQuantity() );
		return orHprRepository.save( existingOrHpr );
	}

	@Override
	public void deleteOrderHasProductByCompositeId(Long orderId, Long productId) {
		OrderHasProduct existingP = getOrderHasProductByCompositeId(orderId, productId);
		orHprRepository.delete(existingP);		
	}
}
