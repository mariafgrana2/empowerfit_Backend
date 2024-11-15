package com.empowerfit.app.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false)
	private Long id;
	
	@NotBlank(message = "Nombre requerido. Por favor, ingresa tu nombre completo.")
	@Size (max = 50, message = "Nombre no puede exceder 50 caracteres.")
	@Column(name="name", length=50, nullable=false)
	private String name;
	
	
	@NotBlank(message = "Correo requerido.")
    @Email(message = "Correo inválido. Ejemplo: usuario@dominio.com")
	@Column(name="email", length=50, nullable=false)
	private String email;
	
	@NotBlank(message = "Teléfono requerido.")
    @Pattern(regexp =  "^\\d{3}\\s\\d{3}\\s\\d{4}$",
    		message = "Formato inválido. Ejemplo: 812 040 3291")
	@Column(name="phone", length=15, nullable=false)
	private String phone;
	
	@NotBlank(message = "La contraseña es obligatoria.")
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
	@Column(name="password", length=20, nullable=false)
	private String password;
	
	@NotBlank(message = "La confirmación de la contraseña es obligatoria.")
	@Transient
	private String confirmPassword;
	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, phone=%s, password=%s, active=%s]", id, name, email,
				phone, password, active);
	}
	
	
	
	
}
