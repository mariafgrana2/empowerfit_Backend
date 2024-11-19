package com.empowerfit.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductProperties")
 public class ProductProperty {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private Long id;
		@Column(name="Tipo_material", length=20, nullable=false)
		private String material;
		
		@ManyToOne
		@JoinColumn(name = "fk_product_id", nullable = false)
		private Product product;
		
		@ManyToMany
	    @JoinTable(
	            name = "product_has_size"
	    )
		private Set<Size> sizes;
		@ManyToMany
	    @JoinTable(
	            name = "product_has_color"
	    )
		private Set<Color> colors;
		@ManyToMany
	    @JoinTable(
	            name = "product_has_volume"
	    )
		private Set<Volume> volumes;
		
		
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

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

		public Set<Size> getSizes() {
			return sizes;
		}

		public void setSizes(Set<Size> sizes) {
			this.sizes = sizes;
		}

		public Set<Color> getColors() {
			return colors;
		}

		public void setColors(Set<Color> colors) {
			this.colors = colors;
		}

		public Set<Volume> getVolumes() {
			return volumes;
		}

		public void setVolumes(Set<Volume> volumes) {
			this.volumes = volumes;
		}

		@Override
		public String toString() {
			return String.format("ProductProperty [id=%s, material=%s]", id, material);
		}

		public void setActive(boolean b) {
	
			
		}

		
		
}