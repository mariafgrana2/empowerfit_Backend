package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="shopbags")
public class ShopBag {

	@EmbeddedId
    private ShopBagKey id;
	
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "amount", nullable = false)
    private double amount;

	@ManyToOne
    @JoinColumn(name = "fk_order_id", insertable = false, updatable = false)
    private Order order;
	
	
	@ManyToOne
    @JoinColumn(name = "fk_product_id", insertable = false, updatable = false)
    private Product product;
    
    // Constructor protegido para JPA
    protected ShopBag() {}

    // Constructor para inicializar la entidad
    public ShopBag( int quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }
    
    public ShopBagKey getId() {
        return id;
    }

    public void setId(ShopBagKey id) {
        this.id = id;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

	@Override
    public String toString() {
        return String.format(
            "ShopBag [quantity=%d, amount=%.2f]", 
             quantity, amount
        );
    }
}
