package pl.sharefood.project.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sharefood.project.repository.UserRepository;

@SpringBootTest
class UserControllerTest {
  @Autowired
  private UserRepository userRepository;

  @Test
  public void testSaveUser() {

  }
}