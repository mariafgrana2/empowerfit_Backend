package com.empowerfit.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
	private Long id;
	@Column(name="name", length=50, nullable=false)
	private String name;
	@Column(name="email", length=50, nullable=false)
	private String email;
	@Column(name="phone", length=15, nullable=false)
	private String phone;
	@Column(name="password", length=20, nullable=false)
	private String password;
	@Column(name="active")
	private boolean active;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	protected User() {}

	public User(String name, String email, String phone, String password, boolean active) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.active = active;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, phone=%s, password=%s, active=%s]", id, name, email,
				phone, password, active);
	}
	
	
	
	
}
