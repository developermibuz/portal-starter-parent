package uz.mib.center.core.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import uz.mib.center.core.common.error.CommonRestControlAdvice;
import uz.mib.center.core.common.service.ErrorService;
import uz.mib.center.core.common.service.impl.DevErrorService;
import uz.mib.center.core.common.service.impl.ProdErrorService;

@Configuration(proxyBeanMethods = false)
@Import(CommonRestControlAdvice.class)
public class ErrorConfiguration {

    @Bean
    @Profile("!prod")
    ErrorService devErrorService() {
        return new DevErrorService();
    }

    @Bean
    @Profile("prod")
    ErrorService prodErrorService() {
        return new ProdErrorService();
    }
}
