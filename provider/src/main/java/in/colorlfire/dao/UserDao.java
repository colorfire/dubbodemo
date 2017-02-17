package in.colorlfire.dao;

import in.colorfire.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author colorfire on 16/12/25
 */
@Component
public interface UserDao extends CrudRepository<User, Long> {

  public User save(User user);

  List<User> findByUsername(String username);
}
