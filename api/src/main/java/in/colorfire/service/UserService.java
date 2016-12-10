package in.colorfire.service;

import in.colorfire.entity.User;

/**
 * 用户接口定义
 *
 * @author colorfire on 16/12/2
 */

public interface UserService {

  public String hello(String name);

  public User getUser(String username);

}
