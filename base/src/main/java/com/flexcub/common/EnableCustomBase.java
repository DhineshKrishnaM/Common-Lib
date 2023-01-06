package com.flexcub.common;

import com.flexcub.common.multitenant.MultiTenantConfig;
import com.flexcub.common.auditing.AuditingConfig;
import com.flexcub.common.cache.EnableCustomCache;
import com.flexcub.common.exception.ExceptionConfig;
import com.flexcub.common.identity.IdentityConfig;
import com.flexcub.common.rest.RestDatabindConfig;
import com.flexcub.common.security.SecurityConfiguration;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({
    AuditingConfig.class,
    MultiTenantConfig.class,
    SecurityConfiguration.class,
    IdentityConfig.class,
    ExceptionConfig.class,
    RestDatabindConfig.class
})
@EnableCustomCache
public @interface EnableCustomBase {
}
