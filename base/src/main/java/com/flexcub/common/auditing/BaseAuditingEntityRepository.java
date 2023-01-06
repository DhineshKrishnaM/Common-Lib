package com.flexcub.common.auditing;

import com.flexcub.common.identity.BaseEntityRepository;

public interface BaseAuditingEntityRepository<T extends BaseAuditingEntity> extends BaseEntityRepository<T> {
}
