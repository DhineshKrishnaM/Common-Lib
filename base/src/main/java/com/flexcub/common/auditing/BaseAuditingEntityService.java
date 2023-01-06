package com.flexcub.common.auditing;

import com.flexcub.common.identity.BaseEntityService;

public interface BaseAuditingEntityService<V extends BaseAuditingDTO, T extends BaseAuditingEntity> extends BaseEntityService<V, T> {
}
