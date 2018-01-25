package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.ReceptionDao;
import org.viarzilin.hospital.model.entity.Reception;
import org.viarzilin.hospital.model.service.ReceptionService;

@Service
public class ReceptionServiceImpl implements ReceptionService {
    @Autowired
    ReceptionDao receptionDao;

    public void setReceptionDao(ReceptionDao receptionDao) {
        this.receptionDao = receptionDao;
    }

    @Override
    @Transactional
    public void addReception(Reception reception) {
        this.receptionDao.addReception(reception);
    }

    @Override
    @Transactional
    public void updateReception(Reception reception) {
        this.receptionDao.updateReception(reception);
    }

    @Override
    @Transactional
    public void removeReception(Integer id) {
        this.receptionDao.removeReception(id);
    }

    @Override
    @Transactional
    public Reception getReceptionById(Integer id) {
        return this.receptionDao.getReceptionById(id);
    }

    @Override
    @Transactional
    public List<Reception> listReceptions() {
        return this.receptionDao.listReceptions();
    }

}