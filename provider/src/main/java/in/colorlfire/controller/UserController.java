package in.colorlfire.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口样例
 *
 * @author colorfire on 16/12/2
 */
@RestController
public class UserController {

  @RequestMapping("/")
  public String index() {
    return "Hello World!";
  }

}
