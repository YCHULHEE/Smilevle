package com.smilevle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ContentVersionStrategy;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.smilevle.common.controller.ExcuteTimeInterceptor;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	ExcuteTimeInterceptor excuteTimeInterceptor() {
		return new ExcuteTimeInterceptor();
	}
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
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(excuteTimeInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/");
	}
	
	// 리소스핸들러를 추가시킴으로써 static 와 public을 제외한 폴더에도 접근가능하게금한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**")
        .addResourceLocations("classpath:/assets/", "/assets/")
        .setCachePeriod(3600)  //60 * 60 * 24 * 365 1year
        .resourceChain(true)
        //.addResolver(new GzipResourceResolver())
        .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
        //.addResolver(new VersionResourceResolver().addVersionStrategy(new ContentVersionStrategy(), "/**"));
        //.addResolver(new WebJarsResourceResolver())
//      .addTransformer(new AppCacheManifestTransformer());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
}
