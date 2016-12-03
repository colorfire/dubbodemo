package in.colorlfire.service.impl;

import in.colorfire.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现
 *
 * @author colorfire on 16/12/2
 */

@Service
public class UserServiceImpl implements UserService {

  public String hello(String name) {
    return "hello "+name+"  this is dubbodemo1";
  }

}
