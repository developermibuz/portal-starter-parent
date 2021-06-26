package uz.mib.center.core.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import uz.mib.center.core.common.properties.LocaleProperties;
import uz.mib.center.core.common.service.IMessages;
import uz.mib.center.core.common.service.impl.MessagesImpl;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(LocaleProperties.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
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

    /**
     * Instantiate the appropriate locale resolution strategy
     *
     * @return locale resolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(new Locale(properties.getDefaultLocale()));
        resolver.setSupportedLocales(Arrays.stream(properties.getSupportedLocales())
                .map(Locale::new)
                .collect(Collectors.toList())
        );
        return resolver;
    }


    /**
     * This interceptor allows visitors to change the locale on a per-request basis
     *
     * @return a LocaleChangeInterceptor object
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName(properties.getDefaultParamName());
        return interceptor;
    }

}
