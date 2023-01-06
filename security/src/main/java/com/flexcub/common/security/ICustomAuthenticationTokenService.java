

package com.flexcub.common.security;

import org.springframework.security.core.Authentication;

public interface ICustomAuthenticationTokenService {

    Authentication getAuthentication(BearerToken bearerToken);

}
