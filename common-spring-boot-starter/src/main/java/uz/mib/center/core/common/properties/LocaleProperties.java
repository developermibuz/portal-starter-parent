package uz.mib.center.core.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("mib.common.locale")
public class LocaleProperties {

    private String resourceBaseName = "i18n/messages";

    private String defaultLocale = "uz";
    private String[] supportedLocales = new String[]{"uz", "ru", "uk"};

    private String defaultParamName = "locale";
}
