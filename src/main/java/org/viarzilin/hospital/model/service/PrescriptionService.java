package org.viarzilin.hospital.model.service;

import org.viarzilin.hospital.model.entity.Prescription;

import java.util.List;

public interface PrescriptionService {
  public void addPrescription(Prescription prescription);

  public void updatePrescription(Prescription prescription);

  public void removePrescription(Integer id);

  public Prescription getPrescriptionById(Integer id);

  public List<Prescription> listPrescriptions();
}
