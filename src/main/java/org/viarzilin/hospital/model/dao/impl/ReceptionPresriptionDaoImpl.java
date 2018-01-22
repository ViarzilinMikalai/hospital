package org.viarzilin.hospital.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.viarzilin.hospital.model.dao.ReceptionPrescriptionDao;
import org.viarzilin.hospital.model.entity.ReceptionPrescription;

import java.util.List;

@Repository
public class ReceptionPresriptionDaoImpl implements ReceptionPrescriptionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionPresriptionDaoImpl.class);

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() { return sessionFactory.getCurrentSession();};

    @Override
    public void addReceptionPrescription(ReceptionPrescription receptionPrescription) {
        getSession().persist(receptionPrescription);
        LOGGER.info("ReceptionPrescription successfully saved. ReceptionPrescription details: " + receptionPrescription);
    }

    @Override
    public void updateReceptionPrescription(ReceptionPrescription receptionPrescription) {
        getSession().update(receptionPrescription);
        LOGGER.info("ReceptionPrescription successfully update. ReceptionPrescription details: " + receptionPrescription);
    }

    @Override
    public void removeReceptionPrescription(Integer id) {

        ReceptionPrescription receptionPrescription = (ReceptionPrescription) getSession().load(ReceptionPrescription.class, id);

        if(receptionPrescription !=null){
            getSession().delete(receptionPrescription);
        }
        LOGGER.info("ReceptionPrescription successfully removed. ReceptionPrescription details: " + receptionPrescription);
    }

    @Override
    public ReceptionPrescription getReceptionPrescriptionById(Integer id) {

        ReceptionPrescription receptionPrescription = (ReceptionPrescription) getSession().load(ReceptionPrescription.class, id);
        LOGGER.info("ReceptionPrescription successfully loaded. ReceptionPrescription details: " + receptionPrescription);

        return receptionPrescription;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ReceptionPrescription> listReceptionPrescriptions() {

        List<ReceptionPrescription> receptionPrescriptionList = getSession().createQuery("from ReceptionPrescription").list();

        for(ReceptionPrescription receptionPrescription : receptionPrescriptionList){
            LOGGER.info("ReceptionPrescription list: " + receptionPrescription);
        }

        return receptionPrescriptionList;
    }}
