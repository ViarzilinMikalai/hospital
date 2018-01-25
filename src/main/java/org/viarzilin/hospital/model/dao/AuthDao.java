package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.entity.Auth;

public interface AuthDao {
  public void addAuth(Auth auth);

  public void updateAuth(Auth auth);

  public void removeAuth(Integer id);

  public Auth getAuthById(Integer id);

  public List<Auth> listAuthes();

}
