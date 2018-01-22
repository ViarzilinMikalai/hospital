package org.viarzilin.hospital.model.service;

import java.util.List;
import org.viarzilin.hospital.model.entity.User;

public interface UserService {

  public void addUser(User user);

  public void updateUser (User user);

  public void removeUser (Integer id);

  public User getUserById (Integer id);

  public List<User> listUsers();
}
