package com.flexcub.common.auditing;

import com.flexcub.common.identity.BaseEntityController;
import com.flexcub.common.security.ISecurityContext;


import org.springframework.http.HttpMethod;

import java.util.Map;

public abstract class BaseAuditingEntityController<V extends BaseAuditingDTO, T extends BaseAuditingEntity>
    extends BaseEntityController<V, T> {

    protected BaseAuditingEntityController(final BaseAuditingEntityService<V, T> service,
                                           final ISecurityContext securityContext,
                                           final Map<HttpMethod, String> securityExpression) {
        super(service, securityContext, securityExpression);
    }

}
