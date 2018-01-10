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
  public void removePrescription(Integer idPrescription) {
    this.prescriptionDao.removePrescription(idPrescription);
  }

  @Override
  @Transactional
  public Prescription getPrescById(Integer idPrescription) {
    return this.prescriptionDao.getPrescById(idPrescription);
  }

  @Override
  @Transactional
  public List<Prescription> getAllPresc() {
    return this.prescriptionDao.getAllPresc();
  }

}
