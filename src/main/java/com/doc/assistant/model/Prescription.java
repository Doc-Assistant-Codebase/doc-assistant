package com.doc.assistant.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Prescription {
	private Integer prescriptionId;
	private Integer patientId;
	private Date prescriptionDate;
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
	public Date getPrescriptionDate() {
		return prescriptionDate;
	}
	
	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public List<Map<Integer, String>> getMedicineIntakeInstructionsMap() {
		return medicineIntakeInstructionsMap;
	}

	public void setMedicineIntakeInstructionsMap(List<Map<Integer, String>> medicineIntakeInstructionsMap) {
		this.medicineIntakeInstructionsMap = medicineIntakeInstructionsMap;
	}
}