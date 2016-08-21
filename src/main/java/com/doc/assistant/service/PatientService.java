package com.doc.assistant.service;

import java.util.List;

import com.doc.assistant.model.Patient;

public interface PatientService {
	
	List<Patient> getAllPatients();
	
	Patient searchByName(String name);
	
	Patient findById(Integer id);
	
	void savePatient(Patient patient);
	
	void deletePatient(Integer id);
	
	void updatePatient(Integer id, Patient updatedPatient);
}