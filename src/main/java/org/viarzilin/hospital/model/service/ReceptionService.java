package org.viarzilin.hospital.model.service;

import org.viarzilin.hospital.model.domain.Reception;

import java.util.List;

public interface ReceptionService {
    void addReception (Reception reception);

    void updateReception (Reception reception);

    void removeReception (Integer id);

    Reception getReceptionById (Integer id);

    List<Reception> listReceptions();

    List<Reception> listHospitalizedReceptions();

    void dischargePatient (Reception reception);

}
