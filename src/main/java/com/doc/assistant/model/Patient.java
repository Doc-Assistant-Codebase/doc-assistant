package com.doc.assistant.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.doc.assistant.util.datetimeconverters.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PATIENT_MASTER")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_ID", unique = true, nullable = false)
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
   	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime lastVisitDate;
	
	@Column(name = "NEXT_VISIT_DATE", nullable = false)
   	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime nextVisitDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonManagedReference
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
	
	public LocalDateTime getLastVisitDate() {
		return lastVisitDate;
	}
	
	public void setLastVisitDate(LocalDateTime lastVisitDate) {
		this.lastVisitDate = lastVisitDate;
	}
	
	public LocalDateTime getNextVisitDate() {
		return nextVisitDate;
	}
	
	public void setNextVisitDate(LocalDateTime nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public Set<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(Set<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}