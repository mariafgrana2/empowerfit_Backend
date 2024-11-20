package com.empowerfit.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="order_date")
	private LocalDateTime orderDate;
	
	@Column(name="total")
	private Double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	@JsonIgnoreProperties({"name", "email", "phone", "password", "active", "privileges", "createdAt", "updatedAt"})
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "fk_status_id")
	private Status status;

	
	@ManyToOne
	@JoinColumn(name = "fk_address_id")
    private Address address;
	
	public Order() {}

	public Order(LocalDateTime orderDate, Double totalAmount) {
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return String.format("Order [id=%s, orderDate=%s, totalAmount=%s]", id, orderDate, totalAmount);
	}
}
