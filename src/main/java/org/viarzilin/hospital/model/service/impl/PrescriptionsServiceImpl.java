package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.PrescriptionDao;
import org.viarzilin.hospital.model.entity.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionsService;

public class PrescriptionsServiceImpl implements PrescriptionsService {
  private PrescriptionDao prescriptionDao;

  public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
    this.prescriptionDao = prescriptionDao;
  }


  @Override
  @Transactional
  public void addPrescription(Prescription prescription) {
    this.prescriptionDao.addPrescription(prescription);
  }

  @Override
  @Transactional
  public void updatePrescription(Prescription prescription) {
    this.prescriptionDao.updatePrescription(prescription);
  }

  @Override
  @Transactional
  public void removePrescription(Integer id) {
    this.prescriptionDao.removePrescription(id);
  }

  @Override
  @Transactional
  public Prescription getPrescById(Integer id) {
    return this.prescriptionDao.getPrescById(id);
  }

  @Override
  @Transactional
  public List<Prescription> getAllPresc() {
    return this.prescriptionDao.getAllPresc();
  }

}
