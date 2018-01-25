package org.viarzilin.hospital.model.service;

import org.viarzilin.hospital.model.domain.Reception;

import java.util.List;

public interface ReceptionService {
    public void addReception (Reception reception);

    public void updateReception (Reception reception);

    public void removeReception (Integer id);

    public Reception getReceptionById (Integer id);

    public List<Reception> listReceptions();
}
