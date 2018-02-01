package org.viarzilin.hospital.model.dao;

import org.viarzilin.hospital.model.domain.Rprescription;

import java.util.List;

public interface RprescriptionDao {

    void addRprescription (Rprescription rprescription);

    void updateRprescription (Rprescription rprescription);

    void removeRprescription (Integer id);

    Rprescription getRprescriptionById (Integer id);

    List<Rprescription> listRprescriptions();

}
