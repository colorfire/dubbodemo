package in.colorfire.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.io.SerializablePermission;

/**
 * 用户实体类
 * @author colorfire on 16/12/10
 */
@Entity
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码(加密存储)
   */
  private String password;

  /**
   * 用户角色
   */
  private String role;

  public User() {}

  public User(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return String.format(
            "User[id=%d, username='%s', password='%s']",
            id, username, password);
  }
}
