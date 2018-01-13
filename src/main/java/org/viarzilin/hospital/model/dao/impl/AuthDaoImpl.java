package org.viarzilin.hospital.model.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.viarzilin.hospital.model.dao.AuthDao;
import org.viarzilin.hospital.model.entity.Auth;


@Repository
public class AuthDaoImpl implements AuthDao {


  private static final Logger lOGGER = LoggerFactory.getLogger(AuthDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public void addAuth(Auth auth) {
    getSession().persist(auth);
    lOGGER.info("Auth successfully saved:" + auth);

  }

  @Override
  public void updateAuth(Auth auth) {
    getSession().update(auth);
    lOGGER.info("Auth saccessfully update:" + auth);

  }

  @Override
  public void removeAuth(Integer idAuth) {
    Auth auth = (Auth) getSession().load(Auth.class,idAuth);

    if (auth !=null){
      getSession().delete(auth);
    }
    lOGGER.info("Auth successfully deleted" + auth);

  }

  @Override
  public Auth getAuthById(Integer idAuth) {
    Auth auth = (Auth) getSession().load(Auth.class, idAuth);
    lOGGER.info("Auth successfully loaded: " + auth);
    return auth;
  }

  @Override
  public Auth getAuthByLogin(String login) {
    Query query = getSession().createQuery("from Auth where login = :login");
    query.setParameter("login", login);
    Auth auth = (Auth)query.uniqueResult();

    lOGGER.info("Auth successfully loaded: " + auth);
    return auth;
  }

  @Override
  public Auth getStaffByEmail(String email) {
    Query query = getSession().createQuery("from Auth where email = :email");
    query.setParameter("email", email);
    Auth auth = (Auth)query.uniqueResult();

    lOGGER.info("Auth successfully loaded: " + auth);
    return auth;
  }

  @Override
  public Auth getAuthByStafId(Integer staffId) {
    Auth auth = (Auth) getSession().load(Auth.class, staffId);
    lOGGER.info("Auth successfully loaded: " + auth);
    return auth;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Auth> getAllAuthes() {

      List<Auth> authList = getSession().createQuery("from Auth").list();

      for(Auth auth: authList){
        lOGGER.info("Auth list: " + auth);
      }

      return authList;
  }
}
