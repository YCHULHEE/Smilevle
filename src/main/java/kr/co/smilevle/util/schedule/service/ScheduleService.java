package kr.co.smilevle.util.schedule.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleService { 
	
	public void run(){
		Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR , 2);
        date.set(Calendar.AM_PM, Calendar.AM);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
  
      
      Timer timer = new Timer();
      SimpleDateFormat Format = new SimpleDateFormat("HHmm");
      String HOUR = Format.format(date.getTime());
      
      TimerTask TimerTask = new TimerTask() {
      
      // 02시가 되면 fn_PVConnect 메소드 실행
      @Override
      public void run() {
          
          String TT = "09";
          String HH = "18";
          int stnIds = 283;
          String PVresponse;
          if(HOUR.equals("0200")) 
          {
        	  
          }
      }
  };      /*11*60*60*1000 24*60*60*1000*/
         //scheduleAtFixedRate(TimerTask 클래스의 run 메소드 실행, 수행시간, 수행주기)
          timer.scheduleAtFixedRate(TimerTask, 6000, 6000);
	    }
}
