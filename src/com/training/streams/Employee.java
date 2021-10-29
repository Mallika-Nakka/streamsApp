package com.training.streams;

public class Employee {
	//Instance variables
	String name,city;
	Integer empId;
	
	//parameter constructor
	public Employee(String name, String city, int empId) {
		this.name = name;
		this.city = city;
		this.empId = empId;
	}
	//default constructor 
	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", empId=" + empId + "]";
	}
	
	
}
