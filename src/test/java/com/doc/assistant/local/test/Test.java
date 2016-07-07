package com.doc.assistant.local.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.doc.assistant.configuration.AppConfiguration;
import com.doc.assistant.model.Medicine;
import com.doc.assistant.service.MedicineService;

public class Test {
	public static void main(String[] args){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		MedicineService medicineService = context.getBean("medicineService", MedicineService.class);
		
		List<Medicine> medicines = medicineService.getAllMedicines();
		System.out.println(medicines);
	}
}