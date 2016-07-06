package com.doc.assistant.model;

import java.util.List;
import java.util.Map;

public class Prescription {
	private Integer id;
	private List<Map<Integer, String>> medicineIntakeInstructionsMap;
	
	public Prescription() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Map<Integer, String>> getMedicineIntakeInstructionsMap() {
		return medicineIntakeInstructionsMap;
	}

	public void setMedicineIntakeInstructionsMap(List<Map<Integer, String>> medicineIntakeInstructionsMap) {
		this.medicineIntakeInstructionsMap = medicineIntakeInstructionsMap;
	}
}