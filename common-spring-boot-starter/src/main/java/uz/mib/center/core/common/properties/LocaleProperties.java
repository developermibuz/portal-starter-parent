package uz.mib.center.core.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("mib.core.common.locale")
public class LocaleProperties {

    private String resourceBaseName = "i18n/messages";
}
