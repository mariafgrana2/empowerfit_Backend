package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sizes")

public class Size {	
	
	@Id
 	@GeneratedValue(strategy=GenerationType.IDENTITY)
 	
	private Long id;
 	
	@Column(name="name_size", length=45, nullable=false)
 	private String size;
	
	protected Size () {}

	public Size(String size) {
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format("Size [id=%s, size=%s]", id, size);
	}
	
}