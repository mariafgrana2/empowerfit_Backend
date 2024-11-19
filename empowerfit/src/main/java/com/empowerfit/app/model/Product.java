package com.empowerfit.app.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", length=200, nullable=false)
    private String name;
    @Column(name="description", length=1000, nullable=false)
    private String description;
    @Column(name="price", length=11, nullable=false)
    private Double price;
    @Column(name="imageUrl", length=350, nullable=false)
    private String imageUrl;
    @Column(name="stock", length=50, nullable=false)
    private Integer stock;
    @Column(name="pieces", length=50, nullable=false)
    private Integer pieces;

   
    @OneToMany(mappedBy = "product")
    private List<ShopBag> shopBags;
    
    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private Category category;
   
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	protected Product() {}

    public Product(String name, String description, Double price, String imageUrl, Integer stock, Integer pieces) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stock = stock;
        this.pieces = pieces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }
    
    public List<ShopBag> getShopBags() {
		return shopBags;
	}

	public void setShopBags(List<ShopBag> shopBags) {
		this.shopBags = shopBags;
	}

	@Override
    public String toString() {
        return String.format(
            "Product [id=%s, name=%s, description=%s, price=%s, imageUrl=%s, stock=%s, pieces=%s]",
            id, name, description, price, imageUrl, stock, pieces
        );
    }
}
