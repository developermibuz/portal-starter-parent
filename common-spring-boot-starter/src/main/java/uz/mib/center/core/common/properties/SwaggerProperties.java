package uz.mib.center.core.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

@Data
@ConfigurationProperties("mib.common.swagger")
public class SwaggerProperties {

    private boolean enabled = true;

    private String title;
    private String version;

    private Class<?>[] ignoredParameterTypes;

}
