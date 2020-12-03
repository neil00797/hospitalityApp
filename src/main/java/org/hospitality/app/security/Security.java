package org.hospitality.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE= "USER";
    private static final String ADMIN_ROLE="ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(http);
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password(encoder().encode("password")) //password encoder is > than text based password.
                .roles(ADMIN_ROLE)
                .and()
                .withUser("user2")
                .password(encoder().encode("12345")) //{noop} tells spring that it can use a text based password
                .roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/hospitality_db/**/create", "/hospitality_db/**/delete/**").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/hospitality_db/**/read/**", "/hospitality_db/**/all/**").hasRole(USER_ROLE)
                .and()
                .csrf().disable() //disable cross reference
                .formLogin().disable(); //disable form because end point is determined
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
