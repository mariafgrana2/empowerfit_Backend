package com.empowerfit.app.model.composite_key;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Component
@Embeddable
public class OrderProductKey implements Serializable  {
	
		private static final long serialVersionUID = 1L;
		
		@Column( name = "order_id" )
		Long orderId;
		@Column( name = "product_id" )
		Long productId;
		
		public OrderProductKey() {}
		
		public OrderProductKey(Long orderId, Long productId) {
			this.orderId = orderId;
			this.productId = productId;
		}

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

}
