package com.doc.assistant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doc.assistant.dao.PatientDao;
import com.doc.assistant.model.Patient;
import com.doc.assistant.service.PatientService;

@Service("patientService")
@Transactional
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDao patientDao;

	@Override
	public List<Patient> getAllPatients() {
		return patientDao.getAllPatients();
	}

	@Override
	public Patient searchByName(String name) {
		return patientDao.searchByName(name);
	}

	@Override
	public Patient findById(Integer id) {
		return patientDao.findById(id);
	}

	@Override
	public void savePatient(Patient patient) {
		patientDao.savePatient(patient);
	}

	@Override
	public void deletePatient(Integer id) {
		patientDao.deletePatient(id);
	}
	
	@Override
	public void updatePatient(Integer id, Patient updatedPatient){
		patientDao.updatePatient(id, updatedPatient);
	}
}