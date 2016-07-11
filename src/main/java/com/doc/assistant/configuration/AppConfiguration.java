package com.doc.assistant.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.doc.assistant.controller.PatientController;
import com.doc.assistant.dao.MedicineDao;
import com.doc.assistant.dao.impl.MedicineDaoImpl;
import com.doc.assistant.service.impl.MedicineServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = {HibernateConfiguration.class, MedicineDao.class, MedicineDaoImpl.class, MedicineServiceImpl.class, PatientController.class})
public class AppConfiguration {

}
