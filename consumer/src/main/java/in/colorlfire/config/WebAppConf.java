package in.colorlfire.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author colorfire on 16/12/10
 */
@Configuration
public class WebAppConf extends WebMvcConfigurerAdapter {

  @Bean
  public EmbeddedServletContainerCustomizer containerCustomizer() {
    return new EmbeddedServletContainerCustomizer() {
      public void customize(ConfigurableEmbeddedServletContainer container) {
        ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
        container.addErrorPages(error403Page);
      }
    };
  }

}