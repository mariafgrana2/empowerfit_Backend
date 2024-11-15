package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="colors")

public class Color {
		
		@Id
	 	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	 	
		@Column(name="name_color", length=60, nullable=false)
	 	private String color;
	 
		Color() {}

		
		public Color(String color) { 
			this.color = color;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {			
			this.id = id;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return String.format("Color [id=%s, color=%s]", id, color);
		}

}



