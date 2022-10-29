package ao.martins.shoesclean.core.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class CorsConfig {

    @Value("${frontend.url}")
    private String FRONTEND_URL;

    @Bean
    public FilterRegistrationBean<CorsFilter> configFilterRegistrationBean(){

        var all=Collections.singletonList("*");

        var corsConfig=new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList(this.FRONTEND_URL));
        corsConfig.setAllowedHeaders(all);
        corsConfig.setAllowedMethods(all);
//        corsConfig.setAllowCredentials(true);

        var source= new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfig);

        var corsFilterBean=new FilterRegistrationBean<CorsFilter>();
        corsFilterBean.setFilter(new CorsFilter(source));
        corsFilterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return corsFilterBean;
    }
}
