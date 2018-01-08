package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.entity.Prescription;

public interface PrescriptionDao {
  public void addPrescription(Prescription prescription);

  public void updatePrescription(Prescription prescription);

  public void removePrescription(Integer idPrescription);

  public Prescription getPrescById(Integer idPrescription);

  List<Prescription> getAllPresc();

  List<Prescription> getPrescByType(String typePrescription);



}
