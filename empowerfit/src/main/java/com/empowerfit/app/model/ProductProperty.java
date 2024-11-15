package com.empowerfit.app.model;
@Entity
@Table(name="ProductProperties")
 public class ProductProperty {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private Long id;
		private Long size_id;
		@Column(name="Tipo_material", length=20, nullable=false)
		private String material;
		
		protected ProductProperty() {}

		public ProductProperty(Long id, Long size_id, String material) {
			super();
			this.id = id;
			this.size_id = size_id;
			this.material = material;
		}

		
		public Long getId() {
			return id;
		}

		
		public void setId(Long id) {
			this.id = id;
		}

		public Long getSize_id() {
			return size_id;
		}

	
		public void setSize_id(Long size_id) {
			this.size_id = size_id;
		}

		
		public String getMaterial() {
			return material;
		}

		
		public void setMaterial(String material) {
			this.material = material;
		}

		@Override
		public String toString() {
			return String.format("ProductProperty [id=%s, size_id=%s, material=%s]", id, size_id, material);
		}
		
}