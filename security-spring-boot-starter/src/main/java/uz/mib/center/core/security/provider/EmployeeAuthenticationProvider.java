package uz.mib.center.core.security.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import uz.mib.center.core.security.model.SessionEmployee;

@Component
@Slf4j
public class EmployeeAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SessionEmployee.class.isAssignableFrom(authentication);
    }
}
