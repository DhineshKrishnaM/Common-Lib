package com.flexcub.common.multitenant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexcub.common.auditing.BaseAuditingDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MulitTenantDTO extends BaseAuditingDTO {

    private static final long serialVersionUID = -7017364125637408063L;
    @JsonIgnore
    private Long tenantId;
}
