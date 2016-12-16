package in.colorlfire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 启动
 *
 * @author colorfire on 16/12/2.
 */
@SpringBootApplication
//@ImportResource({"classpath:dubbo.xml"})
public class ConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

}