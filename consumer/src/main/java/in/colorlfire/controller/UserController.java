package in.colorlfire.controller;

import in.colorfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping("/hello")
  public String index() {
    return userService.hello("colorfire");
  }

  @RequestMapping(value = { "", "/index" }, method = RequestMethod.GET)
  public String home() {
    return "index";
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  @PreAuthorize("hasAnyRole('admin')")
  public String helloAdmin() {
    return "admin";
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @PreAuthorize("hasAnyRole('admin','user')")
  public String helloUser() {
    return "user";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String username,String password) {
    return "user";
  }

  @RequestMapping("/403")
  public String forbidden() {
    return "403";
  }

}
