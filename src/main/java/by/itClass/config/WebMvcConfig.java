package by.itClass.config;

import by.itClass.constants.ConfigConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"by.itClass"})
public class WebMvcConfig {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(ConfigConstant.VIEW_RESOLVER_SUFFIX);
        viewResolver.setPrefix(ConfigConstant.VIEW_RESOLVER_PREFIX);

        return viewResolver;
    }
}
