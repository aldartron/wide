package co.wide.auth.filter;

import co.wide.auth.filter.provider.AuthorizationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
@RequiredArgsConstructor
public class Filter {

    private final AuthorizationProvider authorizationProvider;

    @Bean
    public FilterRegistrationBean<AuthorizationFilter> authenticateFilter() {
        FilterRegistrationBean<AuthorizationFilter> filter = new FilterRegistrationBean<>();

        filter.setOrder(Ordered.LOWEST_PRECEDENCE);
        filter.setFilter(new AuthorizationFilter(authorizationProvider));
        filter.addUrlPatterns("/api/auth/*");

        return filter;
    }

}
