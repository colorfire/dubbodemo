package in.colorlfire.controller;

import in.colorfire.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户接口样例
 *
 * @author colorfire on 16/12/2
 */
@Controller
public class UserController {

  Logger LOG = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = { "", "/index" }, method = RequestMethod.GET)
  public String home(Model model) {
    String password = userService.getUser("colorfire").getPassword();
    LOG.info("========" +  password);
    model.addAttribute("password", password);
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
    LOG.info("UserName = {}, Password = {}", username, password);
    return "user";
  }

  @RequestMapping("/403")
  public String forbidden() {
    return "403";
  }

}
