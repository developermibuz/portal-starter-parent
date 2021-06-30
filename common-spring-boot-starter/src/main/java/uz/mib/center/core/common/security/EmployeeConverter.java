package uz.mib.center.core.common.security;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import uz.mib.center.core.common.db.entities.EmployeeEntity;
import uz.mib.center.core.common.db.entities.EmployeeRoleEntity;
import uz.mib.center.core.common.db.mapper.EmployeeMapper;
import uz.mib.center.core.security.model.Authority;
import uz.mib.center.core.security.model.Employee;
import uz.mib.center.core.security.model.SessionEmployee;
import uz.mib.center.core.security.provider.AuthenticationConverter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeConverter implements AuthenticationConverter {

    private final EmployeeMapper mapper;

    @Override
    public SessionEmployee convert(Jwt jwt) {

        String userId = Objects.requireNonNull(jwt.getSubject(), "userId");
        long employeeId = StringUtils.equalsIgnoreCase(userId, "fcf292d5-7a9e-45d0-9cbc-2fa98bf26289") ? 1L : 47L;
        EmployeeEntity entity = mapper.findById(employeeId);
        List<EmployeeRoleEntity> roles = mapper.findRolesByEmployeeId(employeeId);

        Employee employee = entity == null ? null : new Employee(entity.getId(), entity.getFio());
        List<Authority> authorities = roles == null ? null : roles.stream()
                .map(r -> new Authority(r.getId(), r.getName()))
                .collect(Collectors.toList());

        return SessionEmployee.builder()
                .jwt(jwt)
                .userId(userId)
                .employeeId(employeeId)
                .employee(employee)
                .authorities(authorities)
                .build();
    }
}
