package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.Prescription;

public interface PrescriptionDao {
  public void addPrescription(Prescription prescription);

  public void updatePrescription(Prescription prescription);

  public void removePrescription(Integer id);

  public Prescription getPrescriptionById(Integer id);

  public List<Prescription> listPrescriptions();
}

