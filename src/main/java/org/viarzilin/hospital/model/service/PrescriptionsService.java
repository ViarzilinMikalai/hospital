package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.entity.Prescription;

public interface PrescriptionsService {
  public void addPrescription(Prescription prescription);

  public void updatePrescription(Prescription prescription);

  public void removePrescription(Integer id);

  public Prescription getPrescById(Integer id);

  List<Prescription> getAllPresc();

}
