package com.smilevle.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.smilevle.corona.service.CoronaService;

@Component
public class Scheculer {
	@Autowired
	CoronaService coronaService;
	
	@Scheduled(cron = "0 20 17 * * *")
	public void updateCorona() throws IOException {
		coronaService.updateCorona();
		System.out.println("코로나 업데이트");
	 }
}

//SELECT avg() , areaCode FROM (SELECT * FROM TBL_Review WHERE TO_CHAR(regdate, 'YYYYMMDD') > '20200511') group by areacode;