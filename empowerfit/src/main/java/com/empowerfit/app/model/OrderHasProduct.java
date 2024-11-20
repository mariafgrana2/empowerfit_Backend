package com.empowerfit.app.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.empowerfit.app.model.composite_key.OrderProductKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="order_has_products")
public class OrderHasProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private OrderProductKey id;
	
	@ManyToOne
	@MapsId("orderId")
    @JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@MapsId("productId")
    @JoinColumn(name = "product_id")
	private Product product;
		
	@Column(name = "quantity")	
	private int quantity;
	
	@Column(name = "order_sold", precision=7, scale=2)	
	private BigDecimal orderSold;

	public OrderHasProduct() {}

	public OrderProductKey getId() {
		return id;
	}

	public void setId(OrderProductKey id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getOrderSold() {
		return orderSold;
	}

	public void setOrderSold(BigDecimal orderSold) {
		this.orderSold = orderSold;
	}
	
	

}