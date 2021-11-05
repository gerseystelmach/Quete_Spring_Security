package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/avenger/assemble").hasRole("CHAMPION")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/secret-bases").hasRole("SHIELDDIRECTOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    /* Cette déclaration permet de déclarer des utilisateurs "en mémoire" -- c'est-à-dire sans base de données.  */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("password")).roles("");
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(passwordEncoder.encode("password"))
                .roles("")
                .and()
                .withUser("Admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .and()
                .withUser("Steve")
                .password(passwordEncoder.encode("motdepasse"))
                .roles("CHAMPION")
                .and()
                .withUser("Nick")
                .password(passwordEncoder.encode("flerken"))
                .roles("SHIELDDIRECTOR");
    }
}
