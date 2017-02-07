package in.colorfire.dao;


import in.colorfire.entity.User;
import in.colorlfire.ProviderApplication;
import in.colorlfire.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * just for test
 *
 * @author colorfire on 16/12/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ProviderApplication.class)
public class UserRepositoryTest {

  @Autowired
  UserDao userDao;

  @Test
  public void findsFirstPageOfCities() {
    userDao.save(new User("colorfire", "age", "role"));

    List<User> user = userDao.findByUsername("colorfire");
    assertThat(user.get(0)).isNotNull();

    userDao.deleteAll();
  }

}