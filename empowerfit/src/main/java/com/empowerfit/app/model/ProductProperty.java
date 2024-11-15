package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductProperties")
 public class ProductProperty {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="size_id")
		private Long id;
		@Column(name="Tipo_material", length=20, nullable=false)
		private String material;
		
		protected ProductProperty() {}

		public ProductProperty(String material) {
			this.material = material;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		@Override
		public String toString() {
			return String.format("ProductProperty [id=%s, material=%s]", id, material);
		}

		
		
}