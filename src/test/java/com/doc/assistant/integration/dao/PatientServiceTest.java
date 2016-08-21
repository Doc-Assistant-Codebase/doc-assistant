package com.doc.assistant.integration.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;

import com.doc.assistant.dao.PatientDao;
import com.doc.assistant.model.Patient;
import com.doc.assistant.model.Prescription;
import com.doc.assistant.test.utils.HibernateTestConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
public class PatientServiceTest extends AbstractDaoTest {

	@Autowired
	private PatientDao patientDao;

	@BeforeMethod
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	@ExpectedDatabase(value = "classpath:/db-state/get_all_patients.xml")
	public void testGetAllPatients() {
		List<Patient> patientList = patientDao.getAllPatients();
		assertEquals(4, patientList.size());
	}
	
	@Test
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	@ExpectedDatabase(value = "classpath:/db-state/get_all_patients.xml")
	public void testFindPatientById_1() {
		Patient patient = patientDao.findById(1);
		assertEquals("Mukesh", patient.getFirstName());
		assertEquals("Soni", patient.getLastName());
	}
	
	@Test
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	@ExpectedDatabase(value = "classpath:/db-state/get_all_patients.xml")
	public void testFindPatientById_3() {
		Patient patient = patientDao.findById(3);
		assertEquals("Pranab", patient.getFirstName());
		assertEquals("Bhattacharya", patient.getLastName());
	}
	
	@Test
	@Transactional @Rollback(true)
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	public void testInsertPatientWithoutPrescription() {
		String lastVisitDate = "2016-08-14 03:04:12.0";
		String nextVisitDate = "2016-08-07 03:04:12.0";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		Patient patient = new Patient();
		patient.setAge(13);
		patient.setFirstName("Sam");
		patient.setHeight(171);
		patient.setLastName("Johnson");
		patient.setLastVisitDate(LocalDateTime.parse(lastVisitDate, formatter));
		patient.setNextVisitDate(LocalDateTime.parse(nextVisitDate, formatter));
		patientDao.savePatient(patient);

		List<Patient> patientList = patientDao.getAllPatients();
		assertEquals(5, patientList.size());
	}
	
	@Test
	@Transactional @Rollback(true)
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	public void testInsertPatientWithPrescription() {
		String lastVisitDate = "2016-08-14 03:04:12.0";
		String nextVisitDate = "2016-08-07 03:04:12.0";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		Patient patient = new Patient();
		patient.setAge(13);
		patient.setFirstName("Sam");
		patient.setHeight(171);
		patient.setLastName("Johnson");
		patient.setLastVisitDate(LocalDateTime.parse(lastVisitDate, formatter));
		patient.setNextVisitDate(LocalDateTime.parse(nextVisitDate, formatter));
		
		Prescription prescription = new Prescription();
		prescription.setPrescriptionDate(LocalDateTime.parse(lastVisitDate, formatter));
		
		Map<Integer, String> instruction = new HashMap<Integer, String>();
		instruction.put(2, "Apply before sleeping.");
		
		prescription.setMedicineIntakeInstructionsMap(instruction);
		prescription.setPatient(patient);
		
		Set<Prescription> presciptionSet = new HashSet<Prescription>();
		presciptionSet.add(prescription);
		
		patient.setPrescriptions(presciptionSet);
		
		patientDao.savePatient(patient);

		List<Patient> patientList = patientDao.getAllPatients();
		assertEquals(5, patientList.size());
		
		for(Patient retrievedPatient : patientList){
			if(retrievedPatient.getFirstName().equalsIgnoreCase("Sam")){
				Set<Prescription> prescriptions = retrievedPatient.getPrescriptions();
				assertEquals(1, prescriptions.size());
				for(Prescription retrievedPrescription : prescriptions){
					Map<Integer, String> medicineIntakeInstruction = retrievedPrescription.getMedicineIntakeInstructionsMap();
					assertEquals("Apply before sleeping.", medicineIntakeInstruction.get(2));
				}
			}
		}	
	}
	
	@Test
	@Transactional @Rollback(true)
	@DatabaseSetup(value = "classpath:/db-state/initial_dataset.xml")
	public void testUpdatePatient() {
		Patient patientToUpdate = patientDao.searchByName("Elon");
		Integer patientId = patientToUpdate.getId();
		patientToUpdate.setFirstName("John");
		patientToUpdate.setAge(45);
		patientDao.updatePatient(patientId, patientToUpdate);
		
		Patient updatedPatient = patientDao.searchByName("John");
		assertEquals("John", updatedPatient.getFirstName());
		assertEquals(45, updatedPatient.getAge());
	}
}