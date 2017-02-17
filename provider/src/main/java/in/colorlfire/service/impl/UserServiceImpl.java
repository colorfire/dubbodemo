package in.colorlfire.service.impl;

import in.colorfire.entity.User;
import in.colorfire.service.UserService;
import in.colorlfire.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author colorfire on 16/12/2
 */
@Service
public class UserServiceImpl implements UserService {

  public UserDao userDao;

  public String hello(String name) {
    return "hello "+name+"  this is dubbodemo1";
  }

  public User getUser(String username) {
    return userDao.findByUsername(username).get(0);
  }

}
