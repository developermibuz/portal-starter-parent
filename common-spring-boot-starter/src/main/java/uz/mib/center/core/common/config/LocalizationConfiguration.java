package uz.mib.center.core.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import uz.mib.center.core.common.properties.LocaleProperties;

import java.util.Locale;

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
