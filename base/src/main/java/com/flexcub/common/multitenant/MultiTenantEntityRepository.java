package com.flexcub.common.multitenant;

import org.springframework.stereotype.Repository;

import com.flexcub.common.auditing.BaseAuditingEntityRepository;

@Repository
public interface MultiTenantEntityRepository<T extends MultiTenantEntity> extends BaseAuditingEntityRepository<T> {

}
