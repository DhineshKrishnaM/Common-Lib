package com.flexcub.common.multitenant;

import com.flexcub.common.auditing.BaseAuditingEntityService;


public interface MultiTenantEntityService<V extends MulitTenantDTO, T extends MultiTenantEntity> extends BaseAuditingEntityService<V, T> {
}
