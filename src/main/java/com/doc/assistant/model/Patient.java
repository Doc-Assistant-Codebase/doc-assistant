package com.doc.assistant.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PATIENT_MASTER")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@Column(name = "HEIGHT", nullable = false)
	private int height;
	
	@Column(name = "LAST_VISIT_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate lastVisitDate;
	
	@Column(name = "NEXT_VISIT_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate nextVisitDate;
	
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
	
	public LocalDate getLastVisitDate() {
		return lastVisitDate;
	}
	
	public void setLastVisitDate(LocalDate lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	
	public LocalDate getNextVisitDate() {
		return nextVisitDate;
	}
	
	public void setNextVisitDate(LocalDate nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}