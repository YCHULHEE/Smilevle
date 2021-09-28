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
	
	@Scheduled(cron = "0 20 22 * * *")
	public void insertCorona() throws IOException {
		coronaService.insertCorona();
		System.out.println("코로나 정보 받아오기");
	 }
}

