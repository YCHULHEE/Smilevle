package com.smilevle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.smilevle.tour.model.TourVO;

@MapperScan(basePackageClasses = SmilevleApplication.class)
@SpringBootApplication
public class SmilevleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmilevleApplication.class, args);
		
	}

}
