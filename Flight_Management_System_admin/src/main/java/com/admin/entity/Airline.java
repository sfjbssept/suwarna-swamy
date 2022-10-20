package com.admin.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Integer id;
	private String name; 
	private Timestamp createdOn;
	private Timestamp updatedOn;
	
	@OneToMany(mappedBy="airLine")
	private List<FlightDetails> flights;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}
	public List<FlightDetails> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightDetails> flights) {
		this.flights = flights;
	}
	
	

}
