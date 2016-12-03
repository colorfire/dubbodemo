package in.colorlfire.controller;

import in.colorfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口样例
 *
 * @author colorfire on 16/12/2
 */
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/")
  public String index() {
    return userService.hello("colorfire");
  }

}
