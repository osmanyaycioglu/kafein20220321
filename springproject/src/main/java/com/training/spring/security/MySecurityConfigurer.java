package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService muds;


    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        BCryptPasswordEncoder encoderLoc = new BCryptPasswordEncoder();
        authParam.userDetailsService(this.muds)
                 .passwordEncoder(encoderLoc);
    }

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.antMatcher("/**")
                 .authorizeHttpRequests()
                 .antMatchers("/api/v1/person/provision/**")
                 .hasAnyRole("ADMIN",
                             "USER")
                 .antMatchers("/actuator/**")
                 .hasAnyRole("ADMIN")
                 .antMatchers("/api/**")
                 .hasAnyRole("ADMIN",
                             "USER")
                 .and()
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
                 .cors()
                 .disable()
                 .csrf()
                 .disable()
                 .httpBasic()
                 .and()
                 .formLogin()
                 .disable();
    }

}
