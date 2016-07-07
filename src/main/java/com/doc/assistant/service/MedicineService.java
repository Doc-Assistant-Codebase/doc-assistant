package com.doc.assistant.service;

import java.util.List;

import com.doc.assistant.model.Medicine;

public interface MedicineService {
	
	List<Medicine> getAllMedicines();
	
	Medicine searchByName(String name);
	
	Medicine findById(Integer id);
	
	void saveMedicine(Medicine medicine);
	
	void deleteMedicine(Integer id);	
}
