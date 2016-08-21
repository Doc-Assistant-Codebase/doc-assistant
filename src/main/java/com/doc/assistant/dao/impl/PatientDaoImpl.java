package com.doc.assistant.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doc.assistant.dao.AbstractDao;
import com.doc.assistant.dao.PatientDao;
import com.doc.assistant.model.Patient;

@Repository
@Transactional
public class PatientDaoImpl extends AbstractDao<Integer, Patient> implements PatientDao {

	@Override
	public List<Patient> getAllPatients() {
		Criteria criteria = createEntityCriteria();
		return (List<Patient>) criteria.list().stream().distinct().collect(Collectors.toList());
	}

	@Override
	public Patient searchByName(String name) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("firstName", name));
        return (Patient) criteria.uniqueResult();
	}

	@Override
	public Patient findById(Integer id) {
		return super.getByKey(id);
	}

	@Override
	public void savePatient(Patient patient) {
		super.persist(patient);
	}

	@Override
	public void deletePatient(Integer id) {
		Query query = getSession().createSQLQuery("delete from PATIENT_MASTER where PATIENT_ID = :id");
        query.setInteger("id", id);
        query.executeUpdate();		
	}

	@Override
	public void updatePatient(Integer id, Patient updatedPatient) {
		Patient patient = super.getByKey(id);
		patient.setFirstName(updatedPatient.getFirstName());
		
	}
}