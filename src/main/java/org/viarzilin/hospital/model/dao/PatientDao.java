package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.Patient;

public interface PatientDao {
  void addPatient(Patient patient);

  void updatePatient(Patient patient);

  void removePatient(Integer id);

  Patient getPatientById(Integer id);

  List<Patient> listPatients();

}
