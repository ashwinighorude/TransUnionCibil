package com.example.Assignment;

public class EmployeeCheck {

	public Integer id;
	public String firstname;
	public String lastname;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public EmployeeCheck(Integer id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof EmployeeCheck))
	        return false;
	    if (obj == this)
	        return true;
	    return this.getId() == ((EmployeeCheck) obj).getId();
	}
	
	
	//overriding hashcode
	
	@Override
	public int hashCode() {
		return id;
	}
	 
	
	
}
