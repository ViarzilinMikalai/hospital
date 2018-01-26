package org.viarzilin.hospital.model.dao.impl;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.viarzilin.hospital.model.domain.Auth;
import org.viarzilin.hospital.model.service.AuthService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
@Transactional

public class AuthDaoImplTest extends AbstractJUnit4SpringContextTests {


  @Autowired
  private AuthService authService;
/**
  @Test
  public void addAuth() throws Exception {
  }
  */

  @Test
  public void testFindAll() {
    // Вытаскиваем все объекты из базы
    List<Auth> authes = authService.listAuthes();
    // Вытаскиваем первый элемент из результирующего набора
    Auth firstElement = authes.get(1);
    // Проверяем объект на существование
    assertNotNull(firstElement);
  }
}