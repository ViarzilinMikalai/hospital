package org.viarzilin.hospital.model.service.impl;


import org.viarzilin.hospital.model.dao.PrescriptionDao;
import org.viarzilin.hospital.model.entity.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
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
  public Prescription getPrescriptionById(Integer id) {
    return this.prescriptionDao.getPrescriptionById(id);
  }

  @Override
  @Transactional
  public List<Prescription> listPrescriptions() {
    return this.prescriptionDao.listPrescriptions();
  }
}
