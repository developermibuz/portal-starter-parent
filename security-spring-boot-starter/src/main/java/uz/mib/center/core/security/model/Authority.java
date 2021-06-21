package uz.mib.center.core.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Authority implements GrantedAuthority {

    private Long id;
    private String shortName;

    @Override
    public String getAuthority() {
        return StringUtils.capitalize(shortName);
    }
}
