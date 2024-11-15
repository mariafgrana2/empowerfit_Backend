package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class ShopBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Especificación explícita del nombre de la columna
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Constructor protegido para JPA
    protected ShopBag() {}

    // Constructor para inicializar la entidad
    public ShopBag(Date date, int quantity, double amount) {
        this.date = date;
        this.quantity = quantity;
        this.amount = amount;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return String.format(
            "ShopBag [id=%s, date=%s, quantity=%d, amount=%.2f]", 
            id, date, quantity, amount
        );
    }
}
