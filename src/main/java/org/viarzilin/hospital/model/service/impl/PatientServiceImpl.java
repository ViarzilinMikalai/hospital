package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.viarzilin.hospital.model.dao.PatientDao;
import org.viarzilin.hospital.model.entity.Patient;
import org.viarzilin.hospital.model.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
  PatientDao patientDao;

  public void setPatientDao(PatientDao patientDao) {
    this.patientDao = patientDao;
  }

  @Override
  public void addPatient(Patient patient) {

  }

  @Override
  public void updatePatient(Patient patient) {

  }

  @Override
  public void removePatient(Integer id) {

  }

  @Override
  public Patient getPrescriptionById(Integer id) {
    return null;
  }

  @Override
  public List<Patient> listPatients() {
    return null;
  }
}
