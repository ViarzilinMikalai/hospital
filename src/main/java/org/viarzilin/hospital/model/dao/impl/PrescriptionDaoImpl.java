package org.viarzilin.hospital.model.dao.impl;

import org.viarzilin.hospital.model.dao.PrescriptionDao;
import org.viarzilin.hospital.model.entity.Prescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void addPrescription(Prescription prescription) {
    getSession().persist(prescription);
    LOGGER.info("Prescription successfully saved. Prescription details: " + prescription);
  }

  @Override
  public void updatePrescription(Prescription prescription) {
    getSession().update(prescription);
    LOGGER.info("Prescription successfully update. Prescription details: " + prescription);
  }

  @Override
  public void removePrescription(Integer id) {

    Prescription prescription = (Prescription) getSession().load(Prescription.class, id);

    if(prescription !=null){
      getSession().delete(prescription);
    }
    LOGGER.info("Prescription successfully removed. Prescription details: " + prescription);
  }

  @Override
  public Prescription getPrescriptionById(Integer id) {

    Prescription prescription = (Prescription) getSession().load(Prescription.class, id);
    LOGGER.info("Prescription successfully loaded. Prescription details: " + prescription);

    return prescription;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Prescription> listPrescriptions() {

    List<Prescription> prescriptionList = getSession().createQuery("from Prescription").list();

    for(Prescription prescription : prescriptionList){
      LOGGER.info("Prescription list: " + prescription);
    }

    return prescriptionList;
  }
}
