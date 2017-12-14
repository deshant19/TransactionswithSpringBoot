package com.springJDBCTemplate.Model;

public class Emp {
	private int id;  
	private String name;  
	private float salary; 
	private String address;
	private int phone;
	  
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int mno) {
		this.phone = mno;
	}
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public String getName() {  
	    return name;  
	}  
	public void setName(String name) {  
	    this.name = name;  
	}  
	public float getSalary() {  
	    return salary;  
	}  
	public void setSalary(float salary) {  
	    this.salary = salary;  
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
	
}
