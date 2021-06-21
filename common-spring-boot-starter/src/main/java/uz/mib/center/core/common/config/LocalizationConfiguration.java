package uz.mib.center.core.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import uz.mib.center.core.common.properties.LocaleProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LocaleProperties.class)
@RequiredArgsConstructor
public class LocalizationConfiguration {

    private final LocaleProperties properties;

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename(properties.getResourceBaseName());
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

}
