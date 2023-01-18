package xyz.pangosoft.ispendpoints.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/login/users/get", "/api/login/users/get/**", "/api/login/users/user/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/usuarios/get", "/api/usuarios/get/**").authenticated()
                .antMatchers(HttpMethod.POST, "/api/login/users/post").authenticated()
                .antMatchers().authenticated()
                .anyRequest().permitAll();
    }
}
