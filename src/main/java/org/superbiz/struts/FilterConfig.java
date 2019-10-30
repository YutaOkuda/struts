package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean siteMeshFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new SiteMeshFilter());
        registrationBean.setName("sitemesh");
        registrationBean.setOrder(0);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean filterDispatcher(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());
        registrationBean.setName("struts2");
        registrationBean.setOrder(1);
        registrationBean.addInitParameter("actionPackages","com.lq");
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/addUserForm.action");
        registrationBean.addUrlPatterns("/addUser.action");
        registrationBean.addUrlPatterns("/findUserForm.action");
        registrationBean.addUrlPatterns("/findUser.action");
        registrationBean.addUrlPatterns("/listAllUsers.action");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean actionContextCleanUp(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());
        registrationBean.setName("struts-cleanup");
        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/addUserForm.action");
        registrationBean.addUrlPatterns("/addUser.action");
        registrationBean.addUrlPatterns("/findUserForm.action");
        registrationBean.addUrlPatterns("/findUser.action");
        registrationBean.addUrlPatterns("/listAllUsers.action");
        return registrationBean;
    }
}
