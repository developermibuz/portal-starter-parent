package uz.mib.center.core.security.provider;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;
import uz.mib.center.core.security.model.SessionEmployee;

public interface AuthenticationConverter extends Converter<Jwt, SessionEmployee> {
}
