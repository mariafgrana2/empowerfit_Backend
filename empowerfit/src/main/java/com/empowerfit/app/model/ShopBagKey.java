package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class ShopBagKey implements Serializable {

	@Column(name = "fk_order_id", nullable = false)
    private Long orderId;
	
	@Column(name = "fk_product_id")
    private Long productId;

    @Column(name = "date", nullable = false)
    private LocalDate date; 

    public ShopBagKey() {}


    // Getters y Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopBagKey that = (ShopBagKey) o;
        return Objects.equals(orderId, that.orderId) &&
               Objects.equals(productId, that.productId) &&
               Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, date);
    }
}
