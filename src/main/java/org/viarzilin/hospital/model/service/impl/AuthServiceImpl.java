package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.AuthDao;
import org.viarzilin.hospital.model.domain.Auth;
import org.viarzilin.hospital.model.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

  @Autowired
  AuthDao authDao;

  public void setAuthDao(AuthDao authDao) {
    this.authDao = authDao;
  }

  @Override
  @Transactional
  public void addAuth(Auth auth) {
    this.authDao.addAuth(auth);
  }

  @Override
  @Transactional
  public void updateAuth(Auth auth) {
    this.authDao.updateAuth(auth);
  }

  @Override
  @Transactional
  public void removeAuth(Integer id) {
    this.authDao.removeAuth(id);
  }

  @Override
  @Transactional
  public Auth getAuthById(Integer id) {
    return this.authDao.getAuthById(id);
  }

  @Override
  @Transactional
  public List<Auth> listAuthes() {
    return this.authDao.listAuthes();
  }
}
