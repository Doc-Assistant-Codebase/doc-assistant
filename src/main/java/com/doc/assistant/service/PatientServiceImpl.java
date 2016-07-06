package com.doc.assistant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doc.assistant.model.Patient;

@Service("userService")
@Transactional
public class PatientServiceImpl implements PatientService {
	private static final AtomicLong counter = new AtomicLong();

	@Override
	public List<Patient> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePatient(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
