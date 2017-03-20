package in.colorlfire.serivce;

import in.colorfire.entity.User;
import in.colorfire.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author colorfire on 16/12/10
 */
public class CustomUserDetailsService implements UserDetailsService {
  private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

  @Resource
  private UserService userService;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUser(username);
    if (user == null) {
      throw new UsernameNotFoundException("not found");
    }

    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

    LOG.info("username:{},role:{}", user.getUsername(), user.getRole());
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            authorities);
  }
}
