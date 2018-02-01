package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.ReceptionDao;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.service.ReceptionService;

@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    ReceptionDao receptionDao;

    @Override
    public void addReception(Reception reception) {
        this.receptionDao.addReception(reception);
    }

    @Override
    public void updateReception(Reception reception) {
        this.receptionDao.updateReception(reception);
    }

    @Override
    public void removeReception(Integer id) {
        this.receptionDao.removeReception(id);
    }

    @Override
    public Reception getReceptionById(Integer id) {
        return this.receptionDao.getReceptionById(id);
    }

    @Override
    public List<Reception> listReceptions() {
        return this.receptionDao.listReceptions();
    }

    @Override
    public List<Reception> listHospitalizedReceptions() {
        return this.receptionDao.listHospitalizedReceptions();
    }
}