package uz.mib.center.core.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import uz.mib.center.core.security.provider.SecurityAccessDeniedHandler;
import uz.mib.center.core.security.provider.AuthenticationConverter;

import javax.annotation.PostConstruct;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@ComponentScan(basePackages = "uz.mib.center.core.security.provider")
@EnableConfigurationProperties(OAuth2ResourceServerProperties.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
public class ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SecurityAccessDeniedHandler accessDeniedHandler;
    private final AuthenticationConverter employeeConverter;


    @PostConstruct
    public void enableAuthenticationContextOnSpawnedThreads() {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Validate tokens through configured OpenID Provider
        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(employeeConverter);
        // Require authentication for all requests
        http.authorizeRequests().anyRequest().authenticated();
        // Allow showing pages within a frame
        http.headers().frameOptions().sameOrigin();
        // Handle auth exceptions
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Bean
    @ConditionalOnMissingBean
    public JwtDecoder jwtDecoderByIssuerUri(OAuth2ResourceServerProperties properties) {
        String issuerUri = properties.getJwt().getIssuerUri();
        return JwtDecoders.<NimbusJwtDecoder>fromIssuerLocation(issuerUri);
    }
}
