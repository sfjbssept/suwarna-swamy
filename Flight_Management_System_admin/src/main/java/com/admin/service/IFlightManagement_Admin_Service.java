package com.admin.service;

import java.util.List;
import java.util.Optional;

import com.admin.entity.Airline;

public interface IFlightManagement_Admin_Service {
	public Integer addAirline(Airline airline);
	public List<Airline> getAllAirlines();
	Optional<Airline> getAirline(Integer Id);
	Airline updateAirline(Airline airline ,Integer id);
	public void deleteAirline(Integer id);
	public void deleteAllAirlines();
}