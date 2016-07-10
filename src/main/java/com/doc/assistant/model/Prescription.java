package com.doc.assistant.model;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import com.doc.assistant.util.datetimeconverters.LocalDateTimeConverter;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRESCRIPTION_ID", unique = true, nullable = false)
	private Integer prescriptionId;
	
	@ManyToOne(targetEntity = com.doc.assistant.model.Patient.class)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	private Patient patient;
	
	@Column(name = "PRESCRIPTION_DATE", nullable = false)
   	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime prescriptionDate;
	
	@ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @CollectionTable(name = "PRESCRIPTION_MEDICINES_DESCRIPTION", joinColumns = @JoinColumn(name = "PRESCRIPTION_ID"))
	@MapKeyColumn(name = "MEDICINE_ID")
	@Column(name = "DESCRIPTION")
	private Map<Integer, String> medicineIntakeInstructionsMap;
	
	public Prescription() { }

	public Integer getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(Integer prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDateTime getPrescriptionDate() {
		return prescriptionDate;
	}
	
	public void setPrescriptionDate(LocalDateTime prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public Map<Integer, String> getMedicineIntakeInstructionsMap() {
		return medicineIntakeInstructionsMap;
	}

	public void setMedicineIntakeInstructionsMap(Map<Integer, String> medicineIntakeInstructionsMap) {
		this.medicineIntakeInstructionsMap = medicineIntakeInstructionsMap;
	}
}