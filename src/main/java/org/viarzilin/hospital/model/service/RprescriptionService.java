package org.viarzilin.hospital.model.service;


import org.viarzilin.hospital.model.entity.Rprescription;

import java.util.List;

public interface RprescriptionService {
    public void addRprescription (Rprescription rprescription);

    public void updateRprescription (Rprescription rprescription);

    public void removeRprescription (Integer id);

    public Rprescription getRprescriptionById (Integer id);

    public List<Rprescription> listRprescriptions();
}
