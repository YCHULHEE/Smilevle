package com.smilevle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.smilevle.tour.model.TourVO;
import com.smilevle.util.MyFilter;


@EnableScheduling
@MapperScan(basePackageClasses = SmilevleApplication.class)
@SpringBootApplication
public class SmilevleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmilevleApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
		// filterRegistrationBean.setUrlPatterns(Collections.singletonList("/filtered/*")); // list 를 받는 메소드
		filterRegistrationBean.addUrlPatterns("/admin/*"); // string 여러개를 가변인자로 받는 메소드
		return filterRegistrationBean;
	}

}
