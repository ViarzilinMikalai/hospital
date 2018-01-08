package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.entity.Auth;

public interface AuthDao {
  public void addAuth(Auth auth);

  public void updateAuth(Auth auth);

  public void deleteAuth(int idAuth);

  public Auth getAuthById(int idAuth);

  public Auth getAuthByLogin (String login);

  public Auth getStaffByEmail (String email);

  public Auth getAuthByStafId (int staffId);

  List<Auth> getAllAuthes();

}
