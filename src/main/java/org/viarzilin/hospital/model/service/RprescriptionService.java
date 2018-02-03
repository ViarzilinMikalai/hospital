package org.viarzilin.hospital.model.service;


import org.viarzilin.hospital.model.domain.Rprescription;

import java.util.List;

public interface RprescriptionService {
  void addRprescription (Rprescription rprescription);

  void updateRprescription (Rprescription rprescription);

  void removeRprescription (Integer id);

  Rprescription getRprescriptionById (Integer id);

  List<Rprescription> listRprescriptions();

  List<Rprescription> listPrescriptionsByReceptionId(Integer id);

}
