package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.Prescription;

public interface PrescriptionDao {
  void addPrescription(Prescription prescription);

  void updatePrescription(Prescription prescription);

  void removePrescription(Integer id);

  Prescription getPrescriptionById(Integer id);

  List<Prescription> listPrescriptions();
}

