package com.smilevle.corona.service;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.smilevle.corona.model.CoronaVO;
import com.smilevle.corona.repository.CoronaRepository;
import com.smilevle.util.MapInfomation;
import com.smilevle.util.parser.CoronaPaser;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class CoronaService {
	@Autowired
    private CoronaRepository coronaRepository;
	
	
	public void updateCorona() throws IOException {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		Date time = new Date();
		String nowTime = format.format(time);
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
		/* URL */ String serviceKey = "=ygq6ckNSsXQ8IGk3A5TnTfFiz6osFZwGkzBBfT6fJzmabC0H1Wd67USpVx3Oyfq88cAKcBpgQbvFz0VZQldbVA%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");

		
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +serviceKeyDecoded); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(nowTime, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(nowTime, "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        CoronaPaser coronaPaser = new CoronaPaser();
        MapInfomation mapInfomation = new MapInfomation();
        Map<String, Integer> coronaMap = coronaPaser.paserCorona(sb.toString());
        Map<String, String> areaMap = mapInfomation.getAreaMap();
        CoronaVO coronaVO = new CoronaVO();
        
        for(String key : coronaMap.keySet()) {
        	coronaVO.setLocalName(key);
        	coronaVO.setCount(coronaMap.get(key));
        	System.out.println(key);
        	if(key.equals("검역")) {
        		continue;
        	}
        	
        	if(key.equals("합계")) {
        		coronaVO.setAreaCode("0");
        	} else {
        		coronaVO.setAreaCode(areaMap.get(key));
        	}
				coronaRepository.update(coronaVO);
        }
        
//        String maxName = selectCoronaMax(coronaMap);
//        
//       	return maxName;
	}
	
	public void insertCorona() throws IOException {
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		Date time = new Date();
		String nowTime = format.format(time);
		
		StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
		/* URL */ String serviceKey = "=ygq6ckNSsXQ8IGk3A5TnTfFiz6osFZwGkzBBfT6fJzmabC0H1Wd67USpVx3Oyfq88cAKcBpgQbvFz0VZQldbVA%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");

		
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") +serviceKeyDecoded); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(nowTime, "UTF-8")); /*검색할 생성일 범위의 시작*/
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(nowTime, "UTF-8")); /*검색할 생성일 범위의 종료*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        CoronaPaser coronaPaser = new CoronaPaser();
        MapInfomation mapInfomation = new MapInfomation();
        // 키 : 지역 그리고 벨류 : 확진자수
        Map<String, Integer> coronaMap = coronaPaser.paserCorona(sb.toString());
        Map<String, String> areaMap = mapInfomation.getInsertAreaMap();
        CoronaVO coronaVO = new CoronaVO();
        
        for(String key : coronaMap.keySet()) {
        	coronaVO.setLocalName(key);
        	coronaVO.setCount(coronaMap.get(key));
        	System.out.println(key);
        	
        	if(key.equals("검역")) {
        		continue;
        	}
        	
        	if(key.equals("세종")) {
        		continue;
        	}
        	
        	if(key.equals("합계")) {
        		coronaVO.setAreaCode("0");
        	} else {
        		coronaVO.setAreaCode(areaMap.get(key));   
        	}
				coronaRepository.insert(coronaVO);
        }
        
//        String maxName = selectCoronaMax(coronaMap);
//        
//       	return maxName;
	}
	
	public CoronaVO selectCoronaLowOrderRandom(int size){
		MapInfomation mapInfomation = new MapInfomation();
		List<CoronaVO> coronaList = coronaRepository.selectList(size);
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		
		CoronaVO corona = coronaList.get(random.nextInt(4));
		corona.setLocalName(mapInfomation.getAreaMap().get(corona.getAreaCode()));
		System.out.println(corona.getAreaCode()+ "하이");
		
		return corona;
	}
	
	
	public List<CoronaVO> selectCoronaList(int size) {
		return coronaRepository.selectList(size);
	}
	
	private String selectCoronaMax(Map<String, Integer> coronaMap) {
		Integer maxValue = Collections.max(coronaMap.values());
		for (String key : coronaMap.keySet()) {
			
            if (maxValue.equals(coronaMap.get(key))) {
                return key;
            }
        }
		return null;
	}
	
	public <K, V> K getKey(Map<K, V> map, V value) {
        // 찾을 hashmap 과 주어진 단서 value
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
