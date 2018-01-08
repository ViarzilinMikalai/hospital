package org.viarzilin.hospital.model.dao.daoImpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

import org.viarzilin.hospital.model.dao.PrescriptionDao;
import org.viarzilin.hospital.model.entity.Prescription;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {

  private static final Logger lOGGER = LoggerFactory.getLogger(PrescriptionDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public void addPrescription(Prescription prescription) {
    getSession().persist(prescription);
    lOGGER.info("Prescription successfully saved:" + prescription);

  }

  @Override
  public void updatePrescription(Prescription prescription) {
    getSession().update(prescription);
    lOGGER.info("Prescription successfully updated" + prescription);

  }

  @Override
  public void removePrescription(Integer idPrescription) {
    Prescription prescription = (Prescription) getSession().load(Prescription.class, idPrescription);
    if (prescription !=null){
      getSession().delete(prescription);
      lOGGER.info("Prescription successfully deleted" + prescription);
    }

  }

  @Override
  public Prescription getPrescById(Integer idPrescription) {
    Prescription prescription = (Prescription)getSession().load(Prescription, idPrescription);
    lOGGER.info("Prescription successfully loaded"  + prescription);
    return prescription;
  }

  @Override
  public List<Prescription> getAllPresc() {
    List<Prescription> prescriptionList = getSession().createQuery("from Prescription").list();

    for(Prescription prescription: prescriptionList){
      lOGGER.info("Prescription list: " + prescription);
    }

    return prescriptionList;
  }

  @Override
  public List<Prescription> getPrescByType(String typePrescription) {

    Query query = (Query) getSession().createQuery("from Prescription where typePrescription = :typePrescription").list();
    query.setParameter("typePrescription", typePrescription);
    List<Prescription> prescriptonList = query.list();

    for(Prescription prescription: prescriptonList){
      lOGGER.info("Prescription list: " + prescription);
    }
    return prescriptonList;

  }
}
