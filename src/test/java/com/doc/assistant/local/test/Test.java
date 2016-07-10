package com.doc.assistant.local.test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.doc.assistant.configuration.AppConfiguration;
import com.doc.assistant.model.Medicine;
import com.doc.assistant.model.Patient;
import com.doc.assistant.model.Prescription;
import com.doc.assistant.service.MedicineService;
import com.doc.assistant.service.PatientService;

public class Test {
	public static void main(String[] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		MedicineService medicineService = context.getBean("medicineService", MedicineService.class);
		
		List<Medicine> medicines = medicineService.getAllMedicines();
		System.out.println(medicines);
		
		Medicine med = new Medicine();
		med.setName("Dettol");
		medicineService.saveMedicine(med);
		medicines = medicineService.getAllMedicines();
		System.out.println(medicines);
		
		PatientService patientService = context.getBean("patientService", PatientService.class);
		
		List<Patient> patients = patientService.getAllPatients();
		
		Patient pat = new Patient();
		pat.setAge(13);
		pat.setFirstName("John");
		pat.setHeight(145);
		pat.setLastName("Musk");
		pat.setLastVisitDate(LocalDateTime.now().minusDays(7));
		pat.setNextVisitDate(LocalDateTime.now().minusDays(14));

		Prescription prescp = new Prescription();
		prescp.setPrescriptionDate(LocalDateTime.now());
		
		Map<Integer, String> instr = new HashMap<Integer, String>();
		instr.put(3, "Take with hot water before sleeping.");
		
		prescp.setMedicineIntakeInstructionsMap(instr);
		prescp.setPatient(pat);
		
		Set<Prescription> presciption = new HashSet<Prescription>();
		presciption.add(prescp);
		
		pat.setPrescriptions(presciption);
		
		patientService.savePatient(pat);
		
		System.out.println(patients);
		for(Patient p : patients){
			System.out.println(p.getFirstName());
			Set<Prescription> pres = p.getPrescriptions();
			for(Prescription pr : pres){
				System.out.println(pr.getPrescriptionId());
				Map<Integer, String> advcs = pr.getMedicineIntakeInstructionsMap();
//				for(Map<Integer, String> adv : advcs){
					advcs.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));
//				}
			}
		}
	}
}