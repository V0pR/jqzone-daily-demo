package com.core.config;

import com.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author wangj
 * @version 1.0
 * @Title: SecurityConfig
 * @Package com.core.config
 * @Description: TODO
 * @date 2020/3/17 22:32
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String rememberMeKey = "v0pr";

    @Autowired
    private UserService userService;

    /**
     * 定制请求授权规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //请求路径"/"允许访问
                .antMatchers("/", "/js/**", "/css/**", "/img/**", "/webjars/**")
                .permitAll()
                //其它请求都需要校验才能访问
                .anyRequest().authenticated()

                .and()
                .formLogin()
                //定义登录的页面"/login"，允许访问
                .loginPage("/login")
                .permitAll()

                .and()
                //默认的"/logout", 允许访问
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()

                .and()
                .rememberMe()
                .key("unique-and-secret")
                .rememberMeCookieDomain("remember-me-cookie-name")
                .tokenValiditySeconds(24 * 60 * 60);

    }

    /**
     * 定义认证规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("admin")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .roles("USER");
        //        auth.userDetailsService(userService).passwordEncoder();
    }
}
