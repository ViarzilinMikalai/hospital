package org.viarzilin.hospital.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.viarzilin.hospital.model.dao.ReceptionDao;
import org.viarzilin.hospital.model.domain.Reception;

import java.util.List;

@Repository
public class ReceptionDaoImpl implements ReceptionDao {

  private static final Logger LOGGER = LoggerFactory.getLogger(ReceptionDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addReception(Reception reception) {
        reception.setReceptionDate(new java.util.Date());
        getSession().persist(reception);
        LOGGER.info("Reception successfully saved. Reception details: " + reception);
    }

    @Override
    public void updateReception(Reception reception) {
        getSession().update(reception);
        LOGGER.info("Reception successfully update. Reception details: " + reception);
    }

    @Override
    public void removeReception(Integer id) {

        Reception reception = (Reception) getSession().load(Reception.class, id);

        if(reception !=null){
            getSession().delete(reception);
        }
        LOGGER.info("Reception successfully removed. Reception details: " + reception);
    }

    @Override
    public Reception getReceptionById(Integer id) {

        Reception reception = (Reception) getSession().load(Reception.class, id);
        LOGGER.info("Reception successfully loaded. Reception details: " + reception);

        return reception;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reception> listReceptions() {

        List<Reception> receptionList = getSession().createQuery("from Reception").list();

        for(Reception reception : receptionList){
            LOGGER.info("Reception list: " + reception);
        }

        return receptionList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reception> listHospitalizedReceptions() {
      List<Reception> hospitalizedReceptionList = getSession().createQuery("from Reception "
          + "where isDischarge='false'").list();

      for(Reception reception : hospitalizedReceptionList){
        LOGGER.info("HospitalizedReception list: " + reception);
      }

      return hospitalizedReceptionList;
    }
}
