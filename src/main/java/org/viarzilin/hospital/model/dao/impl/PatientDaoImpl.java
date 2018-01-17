package org.viarzilin.hospital.model.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.viarzilin.hospital.model.dao.PatientDao;
import org.viarzilin.hospital.model.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{
  private static final Logger LOGGER = LoggerFactory.getLogger(PatientDaoImpl.class);

  @Autowired
  SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }


  @Override
  public void addPatient(Patient patient) {
    getSession().persist(patient);
    LOGGER.info("Patient successfully saved. Patient details: " + patient);
  }

  @Override
  public void updatePatient(Patient patient) {
    getSession().update(patient);
    LOGGER.info("Patient successfully update. Patient details: " + patient);
  }

  @Override
  public void removePatient(Integer id) {

    Patient patient = (Patient) getSession().load(Patient.class, id);

    if(patient !=null){
      getSession().delete(patient);
    }
    LOGGER.info("Patient successfully removed. Patient details: " + patient);
  }

  @Override
  public Patient getPatientById(Integer id) {

    Patient patient = (Patient) getSession().load(Patient.class, id);
    LOGGER.info("Patient successfully loaded. Patient details: " + patient);

    return patient;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Patient> listPatients() {

    List<Patient> patientList = getSession().createQuery("from Patient").list();

    for(Patient patient : patientList){
      LOGGER.info("Patient list: " + patient);
    }

    return patientList;
  }
}
