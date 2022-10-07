package com.rabbit.entity;

public class EmployeeStatus {
	private String message;
	private String status;
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployeeStatus(Employee employee, String status,String message) {
		super();
		this.employee = employee;
		this.status = status;
		this.message = message;
	}
	public EmployeeStatus() {
		super();
	}
	
	

}
