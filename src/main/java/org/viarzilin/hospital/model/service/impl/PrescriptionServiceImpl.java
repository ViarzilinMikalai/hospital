package org.viarzilin.hospital.model.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.viarzilin.hospital.model.dao.PrescriptionDao;
import org.viarzilin.hospital.model.domain.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService {

  @Autowired
  private PrescriptionDao prescriptionDao;

  @Override
  public void addPrescription(Prescription prescription) {
    this.prescriptionDao.addPrescription(prescription);
  }

  @Override
  public void updatePrescription(Prescription prescription) {
    this.prescriptionDao.updatePrescription(prescription);
  }

  @Override
  public void removePrescription(Integer id) {
    this.prescriptionDao.removePrescription(id);
  }

  @Override
  public Prescription getPrescriptionById(Integer id) {
    return this.prescriptionDao.getPrescriptionById(id);
  }

  @Override
  public List<Prescription> listPrescriptions() {
    return this.prescriptionDao.listPrescriptions();
  }
}
