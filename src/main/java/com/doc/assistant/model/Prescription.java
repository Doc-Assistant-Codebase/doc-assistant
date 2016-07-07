package com.doc.assistant.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

public class Prescription {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prescriptionId;
	
	private Integer patientId;
	
	@Column(name = "PRESCRIPTION_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate prescriptionDate;
	
	private List<Map<Integer, String>> medicineIntakeInstructionsMap;
	
	public Prescription() { }

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}	
	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}
	
	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public List<Map<Integer, String>> getMedicineIntakeInstructionsMap() {
		return medicineIntakeInstructionsMap;
	}

	public void setMedicineIntakeInstructionsMap(List<Map<Integer, String>> medicineIntakeInstructionsMap) {
		this.medicineIntakeInstructionsMap = medicineIntakeInstructionsMap;
	}
}