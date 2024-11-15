package com.empowerfit.app.model;
@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name="name_amount", length=45, nullable=false)
	private String amount;
	
	protected Payment(){}

	public Payment(Long id, String amount) {
		this.id = id;
		this.amount = amount;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getAmount() {
		return amount;
	}

	
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("Payment [id=%s, amount=%s]", id, amount);
	}
	

}