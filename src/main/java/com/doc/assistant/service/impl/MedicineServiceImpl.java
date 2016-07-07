package com.doc.assistant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doc.assistant.dao.MedicineDao;
import com.doc.assistant.model.Medicine;
import com.doc.assistant.service.MedicineService;

@Service("medicineService")
@Transactional
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicineDao;

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineDao.getAllMedicines();
	}

	@Override
	public Medicine searchByName(String name) {
		return medicineDao.searchByName(name);
	}

	@Override
	public Medicine findById(Integer id) {
		return medicineDao.findById(id);
	}

	@Override
	public void saveMedicine(Medicine medicine) {
		medicineDao.saveMedicine(medicine);
	}

	@Override
	public void deleteMedicine(Integer id) {
		medicineDao.deleteMedicine(id);
	}
}