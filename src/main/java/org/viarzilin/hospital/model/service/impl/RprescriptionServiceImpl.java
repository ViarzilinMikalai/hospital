package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.RprescriptionDao;
import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.RprescriptionService;

@Service
@Transactional
public class RprescriptionServiceImpl implements RprescriptionService {

    @Autowired
    private RprescriptionDao rprescriptionDao;

    @Override
    public void addRprescription(Rprescription rprescription) {
        this.rprescriptionDao.addRprescription(rprescription);
    }

    @Override
    public void updateRprescription(Rprescription rprescription) {
        this.rprescriptionDao.updateRprescription(rprescription);
    }

    @Override
    public void removeRprescription(Integer id) {
        this.rprescriptionDao.removeRprescription(id);
    }

    @Override
    public Rprescription getRprescriptionById(Integer id) {
        return this.rprescriptionDao.getRprescriptionById(id);
    }

    @Override
    public List<Rprescription> listRprescriptions() {
        return this.rprescriptionDao.listRprescriptions();
    }

    @Override
    public List<Rprescription> listPrescriptionsByReceptionId(Integer id) {
        return this.rprescriptionDao.listPrescriptionsByReceptionId(id);
    }
}