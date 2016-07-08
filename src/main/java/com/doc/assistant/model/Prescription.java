package com.doc.assistant.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PRESCRIPTION")
public class Prescription {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@Column(name = "PRESCRIPTION_ID", unique = true, nullable = false)
	private Integer prescriptionId;
	
	@Column(name = "PATIENT_ID", nullable = false)
	private Integer patientId;
	
	@Column(name = "PRESCRIPTION_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate prescriptionDate;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "MEDICINE_ID")
    @Column(name = "DESCRIPTION")
    @CollectionTable(name = "PRESCRIPTION_MEDICINES_DESCRIPTION", joinColumns = @JoinColumn(name = "prescriptionId"))
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