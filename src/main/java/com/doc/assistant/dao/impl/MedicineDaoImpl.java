package com.doc.assistant.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.doc.assistant.dao.AbstractDao;
import com.doc.assistant.dao.MedicineDao;
import com.doc.assistant.model.Medicine;

public class MedicineDaoImpl extends AbstractDao<Integer, Medicine> implements MedicineDao {

	@Override
	public List<Medicine> getAllMedicines() {
		Criteria criteria = createEntityCriteria();
		return (List<Medicine>) criteria.list();
	}

	@Override
	public Medicine searchByName(String name) {
		Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Medicine) criteria.uniqueResult();
	}

	@Override
	public Medicine findById(Integer id) {
		return super.getByKey(id);
	}

	@Override
	public void saveMedicine(Medicine medicine) {
		super.persist(medicine);
	}

	@Override
	public void deleteMedicine(Integer id) {
		Query query = getSession().createSQLQuery("delete from Medicine where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();		
	}

}
