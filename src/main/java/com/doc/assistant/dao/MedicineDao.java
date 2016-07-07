package com.doc.assistant.dao;

import java.util.List;

import com.doc.assistant.model.Medicine;

public interface MedicineDao {
	
	List<Medicine> getAllMedicines();
	
	Medicine searchByName(String name);
	
	Medicine findById(Integer id);
	
	void saveMedicine(Medicine patient);
	
	void deleteMedicine(Integer id);
	
}