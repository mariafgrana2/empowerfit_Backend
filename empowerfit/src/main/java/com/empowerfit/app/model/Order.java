package com.empowerfit.app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id", nullable=false)
	private Long id;
	@Column(name="purchase_date", nullable=false)
	private LocalDate purchaseDate;
	@Column(name="total_amount", nullable=false)
	private Double totalAmount;
	
	protected Order() {}

	public Order(LocalDate purchaseDate, Double totalAmount) {
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s, purchaseDate=%s, totalAmount=%s]", id, purchaseDate, totalAmount);
	}
	
	
	
	
	
}
