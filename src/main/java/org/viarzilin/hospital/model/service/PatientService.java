package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.entity.Patient;

public interface PatientService {
  public void addPatient(Patient patient);

  public void updatePatient(Patient patient);

  public void removePatient(Integer id);

  public Patient getPatientById(Integer id);

  public List<Patient> listPatients();

}
