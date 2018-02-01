package org.viarzilin.hospital.model.dao;

import java.util.List;
import org.viarzilin.hospital.model.domain.Auth;

public interface AuthDao {

  void addAuth(Auth auth);

  void updateAuth(Auth auth);

  void removeAuth(Integer id);

  Auth getAuthById(Integer id);

  List<Auth> listAuthes();
}
