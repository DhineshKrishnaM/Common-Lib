

package com.flexcub.common.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.inject.Inject;

public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    private final CustomSecurityConfigProperties SecurityConfigProperties;
    private final ICustomAuthenticationTokenService AuthenticationTokenService;

    @Inject
    public SecurityConfigurerAdapter(
        final CustomSecurityConfigProperties customSecurityConfigProperties,
        final ICustomAuthenticationTokenService AuthenticationTokenService) {

        this.SecurityConfigProperties = customSecurityConfigProperties;
        this.AuthenticationTokenService = AuthenticationTokenService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.httpBasic().disable()
            .formLogin().disable()
            .logout().disable()
            .csrf()
            .disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .anonymous().disable()
            .addFilterBefore(
                new CustomAuthenticationFilter(AuthenticationTokenService),
                UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(final WebSecurity web) {
        if (SecurityConfigProperties.isExcludePathPresent()) {
            web.ignoring().antMatchers(SecurityConfigProperties.getExcludePathAsArray());
        }
    }

}
