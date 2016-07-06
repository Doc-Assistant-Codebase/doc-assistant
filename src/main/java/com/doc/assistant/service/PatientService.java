package com.doc.assistant.service;

import java.util.List;

import com.doc.assistant.model.Patient;

public interface PatientService {
	
	List<Patient> getAllUsers();
	
	Patient searchByName(String name);
	
	Patient findById(Integer id);
	

}
