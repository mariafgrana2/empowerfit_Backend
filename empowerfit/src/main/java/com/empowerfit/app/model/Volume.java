package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="volumes")
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Especificación explícita del nombre de la columna
    private Long id;

    @Column(name = "volume_kg", nullable = false)
    private Double kg;

    // Constructor protegido para JPA
    protected Volume() {}

    // Constructor para inicializar la entidad
    public Volume(Double kg) {
        this.kg = kg;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKg() {
        return kg;
    }

    public void setKg(Double kg) {
        this.kg = kg;
    }

    @Override
    public String toString() {
        return String.format("Volume [id=%s, kg=%.2f]", id, kg);
    }
}
<<<<<<< HEAD
=======
	
	

	


>>>>>>> a765c5e719ba254c8dfe38a443c6d716404cf39a
