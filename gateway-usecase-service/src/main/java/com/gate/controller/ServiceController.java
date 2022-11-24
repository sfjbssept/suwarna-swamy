package com.gate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value="/getFlightDetailsDetails/{FlightId}",method=RequestMethod.GET)
	public String getFlights(@PathVariable String flightId) {
		System.out.println("getting flight details for:"+flightId);
		String response=restTemplate.exchange("http://admin-service/flightdetail/{flightId}",
				HttpMethod.GET,null,new ParameterizedTypeReference<String>() {
			
		},flightId).getBody();
		
		System.out.println("Response Received as"+response);
		return "Flight"+flightId+"\n flight details:" +response;
		
		
	}
	
	

}
