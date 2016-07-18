package com.doc.assistant.integration.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.doc.assistant.configuration.AppConfiguration;
import com.doc.assistant.dao.PatientDao;
import com.doc.assistant.model.Patient;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("initial_dataset")
public class PatientDaoIT {
	
	@Autowired
	PatientDao patientDao;
	
	@Test
	public void getAllPatients_Test(){
		List<Patient> patients = patientDao.getAllPatients();
		assertThat(patients).hasSize(4);
	}

}
