package edu.icet.ElecBilling.JWT;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public abstract class WebSecurityConfigurerAdapter {
    public abstract void configure(AuthenticationManagerBuilder auth) throws Exception;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManagerBuilder authenticationManagerBean() throws Exception {
        return null;
    }

    protected abstract void configure(HttpSecurity http) throws Exception;
}
