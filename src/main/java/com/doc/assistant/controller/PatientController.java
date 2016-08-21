package com.doc.assistant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doc.assistant.model.Patient;
import com.doc.assistant.service.PatientService;

@RestController(value = "/api/v1")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	/* URL - http://localhost:8080/doc-assistant/api/v1/patient  */
	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if(patients.isEmpty()){
            return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") int id) {
        Patient patient = patientService.findById(id);
        if(null == patient){
            return new ResponseEntity<Patient>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Patient>(patient, HttpStatus.OK);
    }
}