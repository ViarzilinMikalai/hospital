package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.domain.Patient;

public interface PatientService {
  void addPatient(Patient patient);

  void updatePatient(Patient patient);

  void removePatient(Integer id);

  Patient getPatientById(Integer id);

  List<Patient> listPatients();

}
