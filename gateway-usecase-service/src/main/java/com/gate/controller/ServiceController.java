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
	@RequestMapping(value="/getSchoolDetails/{schoolname}",method=RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("getting school details for:"+schoolname);
		String response=restTemplate.exchange("http://school-service/schooldetail/{schoolname}",
				HttpMethod.GET,null,new ParameterizedTypeReference<String>() {
			
		},schoolname).getBody();
		
		System.out.println("Response Received as"+response);
		return "schoolname"+schoolname+"\n Student details:" +response;
		
		
	}
	
	

}
