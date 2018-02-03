package org.viarzilin.hospital.model.dao.impl;


import org.hibernate.query.Query;
import org.viarzilin.hospital.model.dao.RprescriptionDao;
import org.viarzilin.hospital.model.domain.Rprescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.viarzilin.hospital.model.service.ReceptionService;

@Repository
public class RprescriptionDaoImpl implements RprescriptionDao {

  private static final Logger LOGGER = LoggerFactory.getLogger(RprescriptionDaoImpl.class);

  @Autowired
  ReceptionService receptionService;

  @Autowired
  private SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void addRprescription(Rprescription rprescription) {
    rprescription.setRprescriptionDate(new java.util.Date());
    getSession().persist(rprescription);
    LOGGER.info("Rprescription successfully saved. Rprescription details: " + rprescription);
  }

  @Override
  public void updateRprescription(Rprescription rprescription) {
    getSession().update(rprescription);
    LOGGER.info("Rprescription successfully update. Rprescription details: " + rprescription);
  }

  @Override
  public void removeRprescription(Integer id) {

    Rprescription rprescription = (Rprescription) getSession().load(Rprescription.class, id);

    if(rprescription !=null){
      getSession().delete(rprescription);
    }
    LOGGER.info("Rprescription successfully removed. Rprescription details: " + rprescription);
  }

  @Override
  @SuppressWarnings("unchecked")
  public Rprescription getRprescriptionById(Integer id) {

    Rprescription rprescription = (Rprescription) getSession().load(Rprescription.class, id);
    LOGGER.info("Rprescription successfully loaded. Rprescription details: " + rprescription);

    return rprescription;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Rprescription> listRprescriptions() {

    List<Rprescription> rprescriptionList = getSession().createQuery("from Rprescription").list();

    for(Rprescription rprescription : rprescriptionList){
      LOGGER.info("Rprescription list: " + rprescription);
    }

    return rprescriptionList;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Rprescription> listPrescriptionsByReceptionId(Integer id) {
    Query query = getSession().createQuery("from Rprescription where receptions.id = :id");
    query.setParameter("id", id);
    List<Rprescription> patientPrescriptionsList = query.list();

    for(Rprescription rprescription : patientPrescriptionsList){
      LOGGER.info("Prescriptioins of patient: " + rprescription);
    }
    return patientPrescriptionsList;
  }


  @Override
  public void executeReceptionPrescriptionById(Integer id) {
    Rprescription rprescription = (Rprescription) getSession().load(Rprescription.class, id);
    rprescription.setExecutionDate(new java.util.Date());
    rprescription.setExecuted(true);
    getSession().update(rprescription);
    LOGGER.info("Rprescription successfully execute. Reception details: " + rprescription);
  }

}
