package org.viarzilin.hospital.model.dao;

import org.viarzilin.hospital.model.entity.Reception;

import java.util.List;

public interface ReceptionDao {

    public void addReception (Reception reception);

    public void updateReception (Reception reception);

    public void removeReception (Integer id);

    public Reception getReceptionById (Integer id);

    public List<Reception>listReceptions();
}
