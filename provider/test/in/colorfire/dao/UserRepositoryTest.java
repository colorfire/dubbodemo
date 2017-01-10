package in.colorfire.dao;


import in.colorfire.entity.User;
import in.colorlfire.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * just for test
 *
 * @author colorfire on 16/12/30
 */
@EntityScan("in.colorfire")
@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserDao.class)
public class UserRepositoryTest {

  @Autowired
  UserDao userDao;

  @Test
  public void findsFirstPageOfCities() {
    List<User> user = this.userDao.findByUsername("colorfire");
    assertThat(user.get(0)).isNotNull();
  }

}