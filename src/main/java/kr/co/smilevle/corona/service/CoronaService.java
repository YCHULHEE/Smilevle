package kr.co.smilevle.corona.service;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import kr.co.smilevle.corona.model.Corona;
import kr.co.smilevle.util.parser.CoronaPaser;

import java.io.BufferedReader;
import java.io.IOException;

public class CoronaService {
	public static String selectCorona() throws IOException {
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
        Map<String, Integer> coronaMap = coronaPaser.paserCorona(sb.toString());
        String maxName = selectCoronaMax(coronaMap);
        
       	return maxName;
	}
	
	private static String selectCoronaMax(Map<String, Integer> coronaMap) {
		Integer maxValue = Collections.max(coronaMap.values());
		for (String key : coronaMap.keySet()) {
			
            if (maxValue.equals(coronaMap.get(key))) {
                return key;
            }
        }
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		String hi = selectCorona();
	}
}
