package org.viarzilin.hospital.model.service;

import org.viarzilin.hospital.model.domain.Prescription;

import java.util.List;

public interface PrescriptionService {
  void addPrescription(Prescription prescription);

  void updatePrescription(Prescription prescription);

  void removePrescription(Integer id);

  Prescription getPrescriptionById(Integer id);

  List<Prescription> listPrescriptions();
}
