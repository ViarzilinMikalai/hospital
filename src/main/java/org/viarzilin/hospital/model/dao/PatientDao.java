package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.Patient;

public interface PatientDao {
  public void addPatient(Patient patient);

  public void updatePatient(Patient patient);

  public void removePatient(Integer id);

  public Patient getPatientById(Integer id);

  public List<Patient> listPatients();

}
