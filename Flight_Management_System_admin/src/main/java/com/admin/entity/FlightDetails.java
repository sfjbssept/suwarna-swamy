package com.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class FlightDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "my_sequence", sequenceName = "dbsequence", initialValue = 320, allocationSize = 10)

	private String flightnumber;
	private Timestamp createdOn;
	private Timestamp updatedOn;
	private Integer noOfBusinessClassSeats;
	private Integer noOfEconomyClassSeats;
	private Integer noOfRows;
	private Float costPerTicket;
	
	private String source;
	private String destination;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Airline airLine;

	public String getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		if (flightnumber != null && flightnumber.startsWith("A")) {
			this.flightnumber = "A" + flightnumber;
		}
		this.flightnumber = flightnumber;
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

	public Integer getNoOfBusinessClassSeats() {
		return noOfBusinessClassSeats;
	}

	public void setNoOfBusinessClassSeats(Integer noOfBusinessClassSeats) {
		this.noOfBusinessClassSeats = noOfBusinessClassSeats;
	}

	public Integer getNoOfEconomyClassSeats() {
		return noOfEconomyClassSeats;
	}

	public void setNoOfEconomyClassSeats(Integer noOfEconomyClassSeats) {
		this.noOfEconomyClassSeats = noOfEconomyClassSeats;
	}

	public Integer getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(Integer noOfRows) {
		this.noOfRows = noOfRows;
	}

	public Float getCostPerTicket() {
		return this.costPerTicket;
	}

	public void setCostPerTicket(Float costPerTicket) {
		this.costPerTicket = costPerTicket;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Airline getAirLine() {
		return airLine;
	}

	public void setAirLine(Airline airLine) {
		this.airLine = airLine;
	}
	
}
