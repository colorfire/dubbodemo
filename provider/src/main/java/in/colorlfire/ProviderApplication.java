package in.colorlfire;

import in.colorfire.entity.User;
import in.colorlfire.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 启动
 *
 * @author colorfire on 16/12/2.
 */
@SpringBootApplication
@EntityScan("in.colorfire")
//@ImportResource({"classpath:dubbo.xml"})
public class ProviderApplication {

  private static final Logger LOG = LoggerFactory.getLogger(ProviderApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }
}