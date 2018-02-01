package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.User;

public interface UserDao {
  void addUser(User user);

  void updateUser(User user);

  void removeUser(Integer id);

  User getUserById(Integer id);

  User getUserByUsername(String username);

  List<User> listUsers();

  List<User> listUsersByRoleDoctor();

}