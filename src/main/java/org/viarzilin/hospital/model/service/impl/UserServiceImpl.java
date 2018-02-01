package org.viarzilin.hospital.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.dao.UserDao;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  UserDao userDao;

  @Override
  public void addUser(User user) {
    this.userDao.addUser(user);
  }

  @Override
  public void updateUser(User user) {
    this.userDao.updateUser(user);
  }

  @Override
  public void removeUser(Integer id) {
    this.userDao.removeUser(id);
  }

  @Override
  public User getUserById(Integer id) {
    return this.userDao.getUserById(id);
  }

  @Override
  public User getUserByUsername(String username) {
    return this.userDao.getUserByUsername(username);
  }

  @Override
  public List<User> listUsers() {
    return this.userDao.listUsers();
  }

  @Override
  public List<User> listUsersByRoleDoctor() {
    return this.userDao.listUsersByRoleDoctor();
  }
}
