package com.empowerfit.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="status")
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name_status", length=45, nullable=false)
	private String nameStatus;
	
	protected Status () {}
	
	public Status(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}
	
	@Override
	public String toString() {
		return String.format("Status [id=%s, nameStatus=%s]", id, nameStatus);
	}
}
