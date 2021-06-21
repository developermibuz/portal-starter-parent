package uz.mib.center.core.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uz.mib.center.core.common.error.CommonRestControlAdvice;
import uz.mib.center.core.common.properties.CommonProperties;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CommonProperties.class)
@ConditionalOnProperty(prefix = "mib.core.common", value = "enabled", havingValue = "true")
public class CommonAutoConfiguration {


}
