package in.colorlfire.service.impl;

import in.colorfire.entity.User;
import in.colorfire.service.UserService;
import in.colorlfire.dao.UserDao;
import org.apache.commons.logging.Log;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现
 *
 * @author colorfire on 16/12/2
 */
@Service(value = "userSerivce")
public class UserServiceImpl implements UserService {
  Logger LOG = Logger.getLogger(UserServiceImpl.class);

  @Autowired
  @Lazy
  private UserDao userDao;

  public String hello(String name) {
    return "hello " + name + "  this is dubbodemo1";
  }

  public User getUser(String username) {
    List<User> list = userDao.findByUsername(username);
    LOG.info(list.size());
    return list.size() > 0 ? list.get(0) : null;
  }

}
