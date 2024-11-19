package com.empowerfit.app.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id", nullable=false)
	private Long id;
	@Column(name="purchase_date")
	private LocalDate purchaseDate;
	@Column(name="total", nullable=false)
	private Double totalAmount;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
	
	@OneToOne
    @JoinColumn(name = "fk_status_id")
    private Status status;

	@OneToMany(mappedBy = "order") // Esto mapea a la propiedad 'order' en ShopBag
    private List<ShopBag> shopBags;
	
	@ManyToOne
	@JoinColumn(name = "fk_address_id")
    private Address address;
	
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
	
	public List<ShopBag> getShopBags() {
		return shopBags;
	}

	public void setShopBags(List<ShopBag> shopBags) {
		this.shopBags = shopBags;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("Order [id=%s, purchaseDate=%s, totalAmount=%s]", id, purchaseDate, totalAmount);
	}
}
