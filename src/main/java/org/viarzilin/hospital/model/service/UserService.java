package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.domain.User;

public interface UserService {

  void addUser(User user);

  void updateUser (User user);

  void removeUser (Integer id);

  User getUserById (Integer id);

  User getUserByUsername(String username);

  List<User> listUsers();
}
