package uz.mib.center.core.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import uz.mib.center.core.common.properties.LocaleProperties;

import java.util.Locale;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(LocaleProperties.class)
@RequiredArgsConstructor
//@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 9)
public class LocalizationConfiguration {

    private final LocaleProperties properties;

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename(properties.getResourceBaseName());
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }

    /**
     * Instantiate the appropriate locale resolution strategy
     *
     * @return locale resolver
     */
    @Bean
    @Primary
    public LocaleResolver customLocaleResolver() {
        //for this demo, we'll use a SessionLocaleResolver object
        //as the name implies, it stores locale info in the session
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();

        //default to US locale
        resolver.setDefaultLocale(new Locale(properties.getDefaultLocale()));

        //get out
        return resolver;
    }


    /**
     * This interceptor allows visitors to change the locale on a per-request basis
     *
     * @return a LocaleChangeInterceptor object
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        //instantiate the object with an empty constructor
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

        //the request param that we'll use to determine the locale
        interceptor.setParamName(properties.getDefaultParamName());

        //get out
        return interceptor;
    }

}
