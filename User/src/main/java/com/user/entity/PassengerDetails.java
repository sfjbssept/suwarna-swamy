package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PassengerDetails {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Integer passengerId;
	private String name;
	private String gender;
	private String seatNo;
	private String meals;
	@ManyToOne
	@JoinColumn(name = "bookingId", nullable = false)
	private Booking bookingPassenger;
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public String getMeals() {
		return meals;
	}
	public void setMeals(String meals) {
		this.meals = meals;
	}
	public Booking getBookingPassenger() {
		return bookingPassenger;
	}
	public void setBookingPassenger(Booking bookingPassenger) {
		this.bookingPassenger = bookingPassenger;
	}
	
	

}
