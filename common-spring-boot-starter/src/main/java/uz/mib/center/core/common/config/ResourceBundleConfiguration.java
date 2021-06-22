package uz.mib.center.core.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import uz.mib.center.core.common.properties.LocaleProperties;
import uz.mib.center.core.common.service.IMessages;
import uz.mib.center.core.common.service.impl.MessagesImpl;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(LocaleProperties.class)
public class ResourceBundleConfiguration {

    private final LocaleProperties properties;

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename(properties.getResourceBaseName());
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    @Bean
    public IMessages iMessages(ResourceBundleMessageSource messageSource) {
        return new MessagesImpl(messageSource);
    }


}
