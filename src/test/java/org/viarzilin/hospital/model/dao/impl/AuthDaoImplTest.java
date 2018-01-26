package org.viarzilin.hospital.model.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.viarzilin.hospital.config.TestDataBaseConfig;
import org.viarzilin.hospital.model.domain.Auth;
import org.viarzilin.hospital.model.service.AuthService;

import java.util.List;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
public class AuthDaoImplTest {


  @Autowired
  private AuthService authService;


  @Test
  public void testFindAll() {
    // Вытаскиваем все объекты из базы
    List<Auth> authes = authService.listAuthes();
    // Вытаскиваем первый элемент из результирующего набора
    Auth firstElement = authes.get(0);
    // Проверяем объект на существование
    assertNotNull(firstElement);
  }
}