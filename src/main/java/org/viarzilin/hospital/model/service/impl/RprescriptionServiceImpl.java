package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.RprescriptionDao;
import org.viarzilin.hospital.model.entity.Rprescription;
import org.viarzilin.hospital.model.service.RprescriptionService;

@Service
public class RprescriptionServiceImpl implements RprescriptionService {
    @Autowired
    private RprescriptionDao rprescriptionDao;

    public void setRprescriptionDao(RprescriptionDao rprescriptionDao) {
        this.rprescriptionDao = rprescriptionDao;
    }

    @Override
    @Transactional
    public void addRprescription(Rprescription rprescription) {
        this.rprescriptionDao.addRprescription(rprescription);
    }

    @Override
    @Transactional
    public void updateRprescription(Rprescription rprescription) {
        this.rprescriptionDao.updateRprescription(rprescription);
    }

    @Override
    @Transactional
    public void removeRprescription(Integer id) {
        this.rprescriptionDao.removeRprescription(id);
    }

    @Override
    @Transactional
    public Rprescription getRprescriptionById(Integer id) {
        return this.rprescriptionDao.getRprescriptionById(id);
    }

    @Override
    @Transactional
    public List<Rprescription> listRprescriptions() {
        return this.rprescriptionDao.listRprescriptions();
    }

}