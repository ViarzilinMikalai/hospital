package org.viarzilin.hospital.model.service;


import org.viarzilin.hospital.model.entity.ReceptionPrescription;

import java.util.List;

public interface ReceptionPrescriptionService {
    public void addReceptionPrescription(ReceptionPrescription receptionPrescription);

    public void updateReceptionPrescription(ReceptionPrescription receptionPrescription);

    public void removeReceptionPrescription(Integer id);

    public ReceptionPrescription getReceptionPrescriptionById(Integer id);

    public List<ReceptionPrescription> listReceptionPrescriptions();
}
