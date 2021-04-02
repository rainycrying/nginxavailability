package com.rainycrying.nginxavailability.Config;

import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "web.config")
public class WebCasConfig {
    private String casServerUrlPrefix;
    private String casServerLoginUrl;
    private String casClientServerName;
    public String getCasClientServerName() {
        return casClientServerName;
    }
    public void setCasClientServerName(String casClientServerName) {
        this.casClientServerName = casClientServerName;
    }
    public String getCasServerLoginUrl() {
        return casServerLoginUrl;
    }
    public void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }
    public String getCasServerUrlPrefix() {
        return casServerUrlPrefix;
    }
    public void setCasServerUrlPrefix(String casServerUrlPrefix) {
        this.casServerUrlPrefix = casServerUrlPrefix;
    }
    @Bean
    public FilterRegistrationBean singleSignOutFilterBean(SingleSignOutFilter singleSignOutFilter) {
        FilterRegistrationBean<SingleSignOutFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(singleSignOutFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
        registration.addInitParameter("encoding", "utf-8");
        return registration;
    }
    @Bean
    public FilterRegistrationBean authenticationFilterBean(AuthenticationFilter authenticationFilter) {
        FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(authenticationFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("casServerLoginUrl", casServerLoginUrl);
        registration.addInitParameter("serverName", casClientServerName);
        registration.addInitParameter("encoding", "utf-8");
        return registration;
    }
    @Bean
    public FilterRegistrationBean ticketValidationFilterBean( Cas20ProxyReceivingTicketValidationFilter cas20ProxyReceivingTicketValidationFilter ) {
        FilterRegistrationBean<Cas20ProxyReceivingTicketValidationFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("serverName", casClientServerName);
        filterRegistrationBean.addInitParameter("casServerUrlPrefix", casServerUrlPrefix);
        filterRegistrationBean.addInitParameter("encoding", "UTF-8");
        cas20ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
        filterRegistrationBean.setFilter(cas20ProxyReceivingTicketValidationFilter);
        return filterRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean httpServletRequestWrapperFilterBean(HttpServletRequestWrapperFilter httpServletRequestWrapperFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(httpServletRequestWrapperFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("encoding", "utf-8");
        return registration;
    }
    @Bean
    public FilterRegistrationBean assertionThreadLocalFilterBena(AssertionThreadLocalFilter assertionThreadLocalFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(assertionThreadLocalFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("encoding", "utf-8");
        return registration;
    }

    /**
     * 单点退出，可选
     * @return
     */
    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        return new SingleSignOutFilter();
    }

    /**
     * 用户认证，必需
     * @return
     */
    @Bean
    public AuthenticationFilter authenticationFilter() {
        return new AuthenticationFilter();
    }

    /**
     * Ticket校验，必需
     * @return
     */
    @Bean
    public Cas20ProxyReceivingTicketValidationFilter Cas20ProxyReceivingTicketValidationFilter() {
        return new Cas20ProxyReceivingTicketValidationFilter();
    }

    /**
     * 对HttpServletRequest请求包装， 可通过HttpServletRequest.getRemoteUser()方法获得登录用户的登录名，可选
     * @return
     */
    @Bean
    public HttpServletRequestWrapperFilter httpServletRequestWrapperFilter() {
        return new HttpServletRequestWrapperFilter();
    }

    /**
     * 该过滤器使得可以通过org.jasig.cas.client.util.AssertionHolder.getAssertion().getPrincipal().getName()来获取用户的登录名。
     * 这个类把Assertion信息放在ThreadLocal变量中，这样应用程序不在web层也能够获取到当前登录信息
     * 可选
     * @return
     */
    @Bean
    public AssertionThreadLocalFilter assertionThreadLocalFilter() {
        return new AssertionThreadLocalFilter();
    }




}
