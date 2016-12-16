package in.colorlfire.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author colorfire on 16/12/10
 */
@Configuration
public class ErrorPageConfig {

  @Bean
  public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
    return new MyCustomizer();
  }

  private static class MyCustomizer implements EmbeddedServletContainerCustomizer {

    public void customize(ConfigurableEmbeddedServletContainer container) {
      container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
    }

  }

}