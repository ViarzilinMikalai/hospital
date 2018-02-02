package org.viarzilin.hospital.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.viarzilin.hospital.model.dao.AuthDao;
import org.viarzilin.hospital.model.domain.Auth;


@Repository
public class AuthDaoImpl implements AuthDao {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthDaoImpl.class);

  @Autowired
  SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @Override
  public void addAuth(Auth auth) {
    getSession().persist(auth);
    LOGGER.info("Auth successfully saved. Auth details: " + auth);
  }

  @Override
  public void updateAuth(Auth auth) {
    getSession().update(auth);
    LOGGER.info("Auth successfully update. Auth details: " + auth);
  }

  @Override
  public void removeAuth(Integer id) {

    Auth auth = (Auth) getSession().load(Auth.class, id);

    if(auth !=null){
      getSession().delete(auth);
    }
    LOGGER.info("Auth successfully removed. Auth details: " + auth);
  }

  @Override
  public Auth getAuthById(Integer id) {

    Auth auth = (Auth) getSession().load(Auth.class, id);
    LOGGER.info("Auth successfully loaded. Auth details: " + auth);

    return auth;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Auth> listAuthes() {

    List<Auth> authList = getSession().createQuery("from Auth").list();

    for(Auth auth : authList){
      LOGGER.info("Auth list: " + auth);
    }

    return authList;
  }
}
