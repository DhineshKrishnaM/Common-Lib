package com.flexcub.common.multitenant;

import com.flexcub.common.auditing.BaseAuditingEntityController;


import java.util.Map;

import com.flexcub.common.security.ISecurityContext;
import org.springframework.http.HttpMethod;

public abstract class BaseMultiTenantEntityController<V extends MulitTenantDTO, T extends MultiTenantEntity> extends BaseAuditingEntityController<V, T> {

    private ISecurityContext securityContext;
    private final Map<HttpMethod, String> securityExpression;
    private final MultiTenantEntityService<V, T> service;

    protected BaseMultiTenantEntityController(final MultiTenantEntityService<V, T> service,
                                              final ISecurityContext securityContext,
                                              final Map<HttpMethod, String> securityExpression) {
        super(service, securityContext, securityExpression);
        this.securityContext = securityContext;
        this.securityExpression = securityExpression;
        this.service = service;
    }
}
