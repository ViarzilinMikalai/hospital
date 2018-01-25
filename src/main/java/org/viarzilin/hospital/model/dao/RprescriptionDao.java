package org.viarzilin.hospital.model.dao;

import org.viarzilin.hospital.model.domain.Rprescription;

import java.util.List;

public interface RprescriptionDao {

    public void addRprescription (Rprescription rprescription);

    public void updateRprescription (Rprescription rprescription);

    public void removeRprescription (Integer id);

    public Rprescription getRprescriptionById (Integer id);

    public List<Rprescription> listRprescriptions();

}
