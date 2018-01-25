package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.UserDao;
import org.viarzilin.hospital.model.entity.User;
import org.viarzilin.hospital.model.service.UserService;

@Service
public class UserServiceImpl implements UserService{
  @Autowired
  UserDao userDao;

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional
  public void addUser(User user) {
    this.userDao.addUser(user);
  }

  @Override
  @Transactional
  public void updateUser(User user) {
    this.userDao.updateUser(user);
  }

  @Override
  @Transactional
  public void removeUser(Integer id) {
    this.userDao.removeUser(id);
  }

  @Override
  @Transactional
  public User getUserById(Integer id) {
    return this.userDao.getUserById(id);
  }

  @Override
  @Transactional
  public List<User> listUsers() {
    return this.userDao.listUsers();
  }
}
