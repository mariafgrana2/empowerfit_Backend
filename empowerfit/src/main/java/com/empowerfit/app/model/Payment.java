package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="amount", length=45, nullable=false)
	private String amount;
	
	@OneToOne
    @JoinColumn(name = "fk_order_id", nullable = false)
    private Order order;

	protected Payment(){}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment(Long id, String amount) {
		this.id = id;
		this.amount = amount;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAmount() {
		return amount;
	}

	
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("Payment [id=%s, amount=%s]", id, amount);
	}
	

}