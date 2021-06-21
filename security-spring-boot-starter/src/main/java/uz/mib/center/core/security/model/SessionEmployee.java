package uz.mib.center.core.security.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SessionEmployee extends JwtAuthenticationToken {

    private final String userId;
    private final Long employeeId;
    private final Employee employee;
    private final List<Authority> authorities;

    @Builder
    public SessionEmployee(Jwt jwt, String userId, Long employeeId, Employee employee, List<Authority> authorities) {
        super(jwt);
        this.userId = userId;
        this.employeeId = employeeId;
        this.employee = employee;
        this.authorities = authorities;
    }


    @Override
    public Object getPrincipal() {
        return employee;
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return new ArrayList<>(authorities);
    }
}
