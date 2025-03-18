package com.phiworks.config;

import com.phiworks.filter.InitializationFilter;
import com.phiworks.menu.service.MenuService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<InitializationFilter> initializationFilter(MenuService menuService) {
        FilterRegistrationBean<InitializationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new InitializationFilter(menuService));
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrationBean;
    }
}
