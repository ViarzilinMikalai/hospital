package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.ReceptionPrescriptionDao;
import org.viarzilin.hospital.model.entity.ReceptionPrescription;
import org.viarzilin.hospital.model.service.ReceptionPrescriptionService;

@Service
public class ReceptionPrescriptionServiceImpl implements ReceptionPrescriptionService {
    ReceptionPrescriptionDao receptionPrescriptionDao;

    public void setReceptionPrescriptionDao(ReceptionPrescriptionDao receptionPrescriptionDao) {
        this.receptionPrescriptionDao = receptionPrescriptionDao;
    }

    @Override
    @Transactional
    public void addReceptionPrescription(ReceptionPrescription receptionPrescription) {
        this.receptionPrescriptionDao.addReceptionPrescription(receptionPrescription);
    }

    @Override
    @Transactional
    public void updateReceptionPrescription(ReceptionPrescription receptionPrescription) {
        this.receptionPrescriptionDao.updateReceptionPrescription(receptionPrescription);
    }

    @Override
    @Transactional
    public void removeReceptionPrescription(Integer id) {
        this.receptionPrescriptionDao.removeReceptionPrescription(id);
    }

    @Override
    @Transactional
    public ReceptionPrescription getReceptionPrescriptionById(Integer id) {
        return this.receptionPrescriptionDao.getReceptionPrescriptionById(id);
    }

    @Override
    @Transactional
    public List<ReceptionPrescription> listReceptionPrescriptions() {
        return this.receptionPrescriptionDao.listReceptionPrescriptions();
    }

}