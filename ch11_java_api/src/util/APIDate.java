package util;

import java.awt.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class APIDate {
	
	public APIDate()
	{
		
	}
	
	public void showExample() throws ParseException
	{
		// 현재 시간
		// 1. Date 클래스 사용
		Date dateToday = new Date();
		
		// Date 객체가 new Date() 로 생성되는
		// 순간, 해당 Date 객체 (dateToday)
		// 내부에 그 때의 시간이 세팅된다.
		System.out.println(dateToday);
		
		// 2022년 05월 18일 14시 05분 05초
		// 2022/05/18 14:05:05
		// 위와같이 날짜 포맷 설정
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String strToday = sdf.format(dateToday);	// Date 타입의 객체에 세팅된 날짜를 문자열로 리턴 
		System.out.println(strToday);
		
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		strToday = sdf.format(dateToday);
		System.out.println(strToday);
		
		System.out.println("\n======================\n");
		
		// 2. Calendar 클래스 사용
		// .getInstance() 이지만 싱글톤 패턴이
		// 적용되어 있지 않음
		// new Date()와 마찬가지로 Calendar.getInstance()
		// 가 실행되는 시간으로 세팅된 객체가 생성
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday);
		System.out.println(calToday.getTime());
		
		// 날짜 포멧 설정
		strToday = sdf.format(calToday.getTime());
		System.out.println(strToday);
		
		System.out.println("\n==========================\n");
		
		// 3. System 클래스 사용
		// 1970년 1월 1일부터 현재까지의 경과된 시간
		// 을 밀리초 단위로 리턴
		long longToday = System.currentTimeMillis();
		System.out.println(longToday);
		
		// 날짜 포멧 설정
		// SimpleDateFormat 객체의 .format 메소드는 파라미터로 Date 객체 혹은 long 타입을 받도록 오버로딩 되어있다.
		// 1970년 1월 1일부터 경과된 시간에 해당하는 날짜를 리턴
		strToday = sdf.format(longToday);	
		System.out.println(strToday);
		
		String origin = sdf.format(0);  // 0을 넣으면 int 타입이지만 long으로 자동 형변환됨
		System.out.println(origin);
		
		System.out.println("\n=====================\n");
		
		// 다양한 날짜 타입 만들기
		// 1. 2022/05/18 14:27:20
		// 2. 2022-05-18 오후 02:27:20
		// 3. 수 오후 02:27:20
		// 4. 수요일 14:27:20
		// @. 2022.05.18 PM 02:27:20
		
		Date dateNow = new Date();
		sdf = new SimpleDateFormat("yy/M/dd HH:mm:ss");
		String strDay = sdf.format(dateNow);
		System.out.println("1. " + strDay);
		
		sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		strDay = sdf.format(dateNow);
		System.out.println("2. " + strDay);
		
		sdf = new SimpleDateFormat("E a hh:mm:ss");
		strDay = sdf.format(dateNow);
		System.out.println("3. " + strDay);
		
		sdf = new SimpleDateFormat("E요일 HH:mm:ss");
		strDay = sdf.format(dateNow);
		System.out.println("4. " + strDay);
		
		sdf = new SimpleDateFormat("E a hh:mm:ss", Locale.US);
		strDay = sdf.format(dateNow);
		System.out.println("5. " + strDay);
		
		// 현재 미국 날짜는?
		sdf = new SimpleDateFormat("yyyy/MM/dd E a hh:mm:ss", Locale.US);
		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		sdf.setTimeZone(timeZone);
		strDay = sdf.format(dateNow);	
		System.out.println("6. " + strDay);
		
		System.out.println("\n=======================\n");
		
		// 날짜(Date 타입) <-> 문자열(String 타입)
		String strTomorrow = "2022-05-19 15:03:22";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTomorrow = sdf.parse(strTomorrow);
		
		System.out.println(dateTomorrow);
		
		String strTime = "11:20:33";
		sdf = new SimpleDateFormat("HH:mm:ss");
		Date dateTime = sdf.parse(strTime);
		System.out.println(dateTime);
		
		String strYear = "2022.03.20";
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date dateYear = sdf.parse(strYear);
		System.out.println(dateYear);
		
		System.out.println("\n=========================\n");
		
		// 날짜 세팅하기
		Calendar cal = Calendar.getInstance();
		// Month의 경우 1월이 0, 2월 1, 3월 2, ...
		cal.set(1992, 11-1, 25, 12, 30, 20);
		
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strCal = sdf.format(cal.getTime());
		System.out.println(sdf.format(cal.getTime()));
		
		// Date 타입을 Calendar 타입으로 변환
		Date temp = new Date();
		Calendar calTemp = Calendar.getInstance();
		calTemp.setTime(temp);
		
		System.out.println("\n===========================\n");
		
		// 날짜 꺼내기
		String anyTime = "2020.06.21 23:11:21";
		Date dateAnyTime = sdf.parse(anyTime);
		
		Calendar anyCal = Calendar.getInstance();
		anyCal.setTime(dateAnyTime);
		
		// 년도
		System.out.println(anyCal.get(Calendar.YEAR));
		// 월
		System.out.println(anyCal.get(Calendar.MONTH) + 1);
		// 일
		System.out.println(anyCal.get(Calendar.DATE));
		// 시간
		System.out.println(anyCal.get(Calendar.HOUR_OF_DAY));
		// 분
		System.out.println(anyCal.get(Calendar.MINUTE));
		// 초
		System.out.println(anyCal.get(Calendar.SECOND));
		
		
		System.out.println("\n========================\n");
		
		
		// 날짜 연산
		String oneDay = "2022.05.17 12:22:34";
		String twoDay = "2022.05.19 15:32:22";
		
		// 먼저 문자열을 Date 타입으로 바꿔주어야 함
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Date dateOneDay = sdf.parse(oneDay);
		Date dateTwoDay = sdf.parse(twoDay);
		
		// 둘 중 최신 날짜?
		System.out.println(dateOneDay.getTime());
		System.out.println(dateTwoDay.getTime());
		// 밀리초값이 더 클수록 미래다.
		
		long diffMillSec = dateTwoDay.getTime() - dateOneDay.getTime();
		System.out.println(diffMillSec + "밀리초 차이");
		
		long diffSec = diffMillSec / 1000;
		System.out.println(diffSec + "초 차이");
		
		long diffMin = diffSec / 60;
		System.out.println(diffMin + "분 차이");
		
		long diffHour = diffMin / 60;
		System.out.println(diffHour + "시간 차이");
		
		long diffDate = diffHour / 24;
		System.out.println(diffDate + "일 차이");
		
		long diffYear = diffDate / 365;
		System.out.println(diffYear + "년 차이");
		
		// 한줄로
		long diff = diffMillSec / (1000 * 60 * 60 * 24); 
		System.out.println(diff + "일 차이");
		
		System.out.println("\n=======================\n");
		
		// 디데이 계산
		// 오늘 날짜 준비
		Date today = new Date();
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		System.out.println(today);
		
		strToday = sdf.format(today);
		System.out.println(strToday);
		
		Date todate = sdf.parse(strToday);
		System.out.println(todate);
		
		String dday = "2023.02.11";
		Date ddate = sdf.parse(dday);
		
		diffMillSec = todate.getTime() - ddate.getTime();
		diff = diffMillSec / (1000 * 60 * 60 * 24);
		System.out.println("지방선거까지 d-day = " + diff);
		
		dday = "2022.04.11";
		ddate = sdf.parse(dday);
		diffMillSec = todate.getTime() - ddate.getTime();
		diff = diffMillSec / (1000 * 60 * 60 * 24);
		System.out.println("여러분의 교육 기간 = " + diff);
		
		
		System.out.println("\n========================\n");
		
		
		// 날짜 연산 Calendar
		// 한 날짜를 기준으로 날짜를
		// 더하거나 뺄 때 유용
		
		Calendar toCal = Calendar.getInstance();
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(toCal.getTime()));
		
		// 3일 뒤 
		toCal.add(Calendar.DATE, 3);  // ch09_class에서 typing, Dictionary 때도 사용했던 Constants 상수 사용법
		System.out.println(sdf.format(toCal.getTime()));
		
		// 20일 뒤
		toCal.add(Calendar.DATE, 20);
		System.out.println(sdf.format(toCal.getTime()));
		
		// 7일 전
		toCal.add(Calendar.DATE, -7);
		System.out.println(sdf.format(toCal.getTime()));
		
		// 11달 뒤
		toCal.add(Calendar.MONTH, 11);
		System.out.println(sdf.format(toCal.getTime()));
		
		System.out.println("\n==============================\n");
		
		// 달력 만들기
		int year = 2023;
		int month = 2;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, 1);
		System.out.println(sdf.format(calendar.getTime()));
		
		// 해당 달의 마지막 일자(DATE) 얻기
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		
		// 해당 달의 시작 요일
		// 1: 일요일, 2: 월요일, 3: 화요일, ..., 7: 토요일
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		
		System.out.println(year + "년 " + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		int currentDay = 1;
		for(int i = 1; i <= 42; i++) {
			if(i < startDay) {
				System.out.print("\t");
			}else {
				System.out.printf("%2d\t", currentDay);
				currentDay++;
				
				if(currentDay > lastDay) {
					break;
				}
			}
			
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println("\n========================\n");
		
		// 주말을 제외한 달력 만들기
		System.out.println(year + "년 " + month + "월 달력");
		System.out.println("월\t화\t수\t목\t금");
		
		currentDay = 1;
		for(int i = 1; i <= 42; i++) {
			if(i < startDay) {
				if(i != 1) {
					System.out.print("\t");
				}
			}else {
				if(!(i%7==1 || i%7==0)) {
					System.out.printf("%2d\t", currentDay);
				}
				currentDay++;
				
				if(currentDay > lastDay) {
					break;
				}
			}
			
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n\n=======================================\n\n");
		
		
		
		ArrayList<String> commentList = new ArrayList<>();
		commentList.add("Microsoft Windows [Version 10.0.19045.2788]");
		commentList.add("(c) Microsoft Corporation. All rights reserved.");
		commentList.add("C:\\Users\\jimin>");
		
		long currentMillis = System.currentTimeMillis();
		long preMillis = 0;
		int intervalMillis = 50;
		
		for(int i = 0; i < commentList.size(); i++)
		{
			String nextLineDataStr = commentList.get(i);
			char[] nextLineData = nextLineDataStr.toCharArray();
			
			for(int j = 0; j < nextLineData.length; )
			{
				currentMillis = System.currentTimeMillis();
				
				//현재 시간이 정해진 시간 보다 클 때 작동
				if(currentMillis - preMillis >= intervalMillis)
				{
					System.out.print(nextLineData[j]);
					
					preMillis = currentMillis;
					
					
					
					//for문 탈출 조건을 여기서 제어해야됨
					j++;
				}

				/*
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			System.out.println();
		}
	}

}
