package uz.mib.center.core.security.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlobalAuthenticationConfigurer extends GlobalAuthenticationConfigurerAdapter {

    private final uz.mib.center.core.security.provider.EmployeeAuthenticationProvider provider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }
}
