package com.smilevle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
          .addResourceLocations("classpath:/static/")
          .setCachePeriod(604800);
        
        registry.addResourceHandler("/ckUpload/**")
				.addResourceLocations("/resource/ckUpload/");
    }
	
	
//	@Bean
//	ExcuteTimeInterceptor excuteTimeInterceptor() {
//		return new ExcuteTimeInterceptor();
//	}
	@Bean
	  public ViewResolver customViewResolver() {
	      InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	      internalResourceViewResolver.setPrefix("/WEB-INF/");
	      internalResourceViewResolver.setSuffix(".jsp");
	      return internalResourceViewResolver;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
}
