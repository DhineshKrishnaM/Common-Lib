

package com.flexcub.common.security;

import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityConfigurerAdapter securityConfigurerAdapter(
        final CustomSecurityConfigProperties SecurityConfigProperties,
        final ICustomAuthenticationTokenService tokenService) {

        return new SecurityConfigurerAdapter(SecurityConfigProperties, tokenService);
    }

    @Bean
    public RestTemplateBeanPostProcessor securedRestTemplateBeanPostProcessor(final ISecurityContext securityContext) {
        return new RestTemplateBeanPostProcessor(securityContext);
    }

    @Bean
    public SecurityContext securityContext(@Value("${security.adminRoleSecurityExpression:}") final String adminRoleSecurityExpression) {
        return new SecurityContext(securityExpressionChecker(), adminRoleSecurityExpression);
    }

    @Bean
    public SecurityExpressionChecker securityExpressionChecker() {
        return new SecurityExpressionChecker();
    }

    @Bean
    public ICustomAuthenticationTokenService AuthenticationTokenService(final CustomSecurityConfigProperties SecurityConfigProperties) {
        return new CustomAuthenticationTokenService(SecurityConfigProperties, securityExpressionChecker());
    }

    @Bean
    public CustomSecurityConfigProperties SecurityConfigProperties(
        @Value("${security.excludePaths:}") final String[] excludePaths,
        @Value("${security.entrySecurityExpression:}") final String entryExpression,
        @Value("${security.adminRoleSecurityExpression:}") final String adminRoleSecurityExpression) {

        return new CustomSecurityConfigProperties(List.of(excludePaths).map(String::trim), entryExpression, adminRoleSecurityExpression);
    }

}
