package in.colorlfire.serivce;

import in.colorfire.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author colorfire on 16/12/10
 */
public class CustomUserDetailsService implements UserDetailsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsService.class);
  private static Map<String, User> userMap = new HashMap<String, User>();

  static {
    User user = new User("admin", "123456", "admin");
    userMap.put(user.getUsername(), user);

    user = new User("qiuwg", "123456", "user");
    userMap.put(user.getUsername(), user);
  }

  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = userMap.get(s);
    if (user == null) {
      throw new UsernameNotFoundException("not found");
    }
    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    LOGGER.info("username:{},role:{}", user.getUsername(), user.getRole());
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            authorities);
  }
}
