package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.PatientDao;
import org.viarzilin.hospital.model.domain.Patient;
import org.viarzilin.hospital.model.service.PatientService;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

  @Autowired
  PatientDao patientDao;

  @Override
  public void addPatient(Patient patient) {
    this.patientDao.addPatient(patient);
  }

  @Override
  public void updatePatient(Patient patient) {
    this.patientDao.updatePatient(patient);
  }

  @Override
  public void removePatient(Integer id) {
    this.patientDao.removePatient(id);
  }

  @Override
  public Patient getPatientById(Integer id) {
    return this.patientDao.getPatientById(id);
  }

  @Override
  public List<Patient> listPatients() {
    return this.patientDao.listPatients();
  }
}
