package com.doc.assistant.model;

import java.util.Date;
import java.util.Set;

public class Patient {
	private Integer id;
	private String firstName;
	private String lastName;
	private int age;
	private int height;
	private Date lastVisitDate;
	private Date nextVisitDate;
	private Set<Prescription> prescriptions;
	
	public Patient(){	}
	
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Date getLastVisitDate() {
		return lastVisitDate;
	}
	
	public void setLastVisitDate(Date lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	
	public Date getNextVisitDate() {
		return nextVisitDate;
	}
	
	public void setNextVisitDate(Date nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}