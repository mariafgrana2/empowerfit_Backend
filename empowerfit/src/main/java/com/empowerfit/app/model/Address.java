package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="addresses")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Especificación explícita del nombre de la columna
    private Long id;

    @NotBlank(message = "La dirección no puede estar vacía.") 
    @Column(name = "street_address", nullable = false)
    private String streetAddress;
    
    @NotBlank(message = "La ciudad no puede estar vacía.") 
    @Column(name = "city", nullable = false)
    private String city;
    
    @NotBlank(message = "El estado no puede estar vacío.")
    @Column(name = "state", nullable = false)
    private String state;
    
    @NotNull(message = "El código postal es obligatorio.")
    @Column(name = "postal_code", nullable = false)
    @Pattern(regexp = "\\d{5}", message = "El código postal debe constar de 5 dígitos.")
    private String postalCode;

    @NotBlank(message = "El país no puede estar vacío.")
    @Column(name = "country", nullable = false)
    private String country;

    @ManyToOne
	@JoinColumn(name = "fk_user_id")
	private User user;
    
    protected Address() {}

 
    public Address(String streetAddress, String city, String state, String postalCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
    public String toString() {
        return String.format(
            "Address [id=%s, streetAddress=%s, city=%s, state=%s, postalCode=%s, country=%s]", 
            id, streetAddress, city, state, postalCode, country
        );
    }
}

