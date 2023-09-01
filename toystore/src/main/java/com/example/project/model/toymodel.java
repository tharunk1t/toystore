package com.example.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="toystore")
public class toymodel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int toyId;
	
	@Column(name="Varieties")
	private String Varieties;
	private String Address;
	private String Location;
	public int getToyId() {
		return toyId;
	}
	public void setToyId(int toyId) {
		this.toyId = toyId;
	}
	public String getVarieties() {
		return Varieties;
	}
	public void setVarieties(String varieties) {
		Varieties = varieties;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	
}