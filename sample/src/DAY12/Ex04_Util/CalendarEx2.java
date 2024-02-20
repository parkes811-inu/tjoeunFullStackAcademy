package DAY12.Ex04_Util;

import java.text.SimpleDateFormat;

// 2024-02-20 
// MSA 기반 풀스택 교육 13일차

import java.util.Calendar;
import java.util.spi.CalendarNameProvider;

public class CalendarEx2 {
	public static void main(String[] args) {
		// * 현재 날짜/시간 정보로 객체를 생성
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.get((Calendar.YEAR)));
		System.out.println(cal.get((Calendar.MONTH) + 1));
		System.out.println(cal.get((Calendar.DAY_OF_MONTH)));
		
		// 날짜 형식을 지정하는 방법
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) HH:mm:ss");
		// sdf.format( Date 객체 )
		// * 지정한 날짜 형식에 맞게 Date 객체의 날짜/시간 정보를 문자열로 반환하는 메소드
		
		String today = sdf.format(cal.getTime());
		System.out.println(today);
		
		// 현재 날짜로부터 N 시간 후, N 일 후는 언제인지
		// 10분 후
		// cal.add( 시간단위 상수, 날짜/시간 값)
		// : 지정한 시간 단위 만큼 이후의 날짜/시간으로 반환하는 메소드
		cal.add(cal.MINUTE, 10);
		String after10Min = sdf.format(cal.getTime());
		System.out.println("10 분 후 : " + after10Min);
		
		// 1시간 후
		cal.add(cal.HOUR, 1);
		String after1Hour = sdf.format(cal.getTime());
		System.out.println("1 시간 후 : " + after1Hour);
		
		// 1일 후
		cal.add(cal.DAY_OF_MONTH, 1);
		String after1Day = sdf.format(cal.getTime());
		System.out.println("1 일 후 : " + after1Day);
		
		// 이번 주 로또 추첨 일시?
		// * 매일 6시 ~ 24시 까지 판매
		// 추첨일(토요일)에는 오후 8시에 판매 마감
		// 추첨일 오후 8시부터 다음일(일요일) 오전 6시까지는 판매 정지
		// Q. 현재 날짜/시간을 기준으로 로또를 구매한다면,
		// (출력)
		// 추첨일 : 2024/02/24 21:00:00
		Calendar lottoCal = Calendar.getInstance();
		// 구입 불가 조건 1 : 구입이 불가능한 시간으로 세팅 (테스트)
		// lottoCal.set(Calendar.AM_PM, 0);
		// lottoCal.set(Calendar.HOUR, 1);
		
		// 구입 불가 조건 : 토요일 오후 9시
		// lottoCal.set(Calendar.DAY_OF_WEEK, 7);
		// lottoCal.set(Calendar.AM_PM, 1);
		// lottoCal.set(Calendar.HOUR, 9);
		
		
		int 요일 = lottoCal.get(Calendar.DAY_OF_WEEK); 	// 일(1) ~ 토(7)
		int 시간 = lottoCal.get(Calendar.HOUR);
		int ampm = lottoCal.get(Calendar.AM_PM);
		String todayOfWeek = "";
		
		// 요일 : [일1][월2][화3][수4][목5][금6][토7]
		System.out.println("요일 : " + 요일);
		System.out.println("시간 : " + 시간);
		System.out.println("ampm : " + ampm);
		
		// 조건
		// 일요일 6시 ~ 토요일 8시 		: 이번 주 토요일 오후 9시
		switch(요일) {
			case 1 : todayOfWeek = "일"; break;
			case 2 : todayOfWeek = "월"; break;
			case 3 : todayOfWeek = "화"; break;
			case 4 : todayOfWeek = "수"; break;
			case 5 : todayOfWeek = "목"; break;
			case 6 : todayOfWeek = "금"; break;
			case 7 : todayOfWeek = "토"; break;
		}
		System.out.println(todayOfWeek);
		
		// 시간은 고정된 값 : 오후 9시, 0분, 0초
		lottoCal.set(Calendar.AM_PM, 1);		// 오전 : 0, 오후 : 1
		lottoCal.set(Calendar.HOUR, 9);
		lottoCal.set(Calendar.MINUTE, 0);
		lottoCal.set(Calendar.SECOND, 0);
		
		// 구입 가능 여부
		 boolean buyYn = false;
		
		// 로또 구입이 불가한 조건
		// 1. (구입불가) 오전 00시 ~ 06시
		if(ampm == 0 && 시간 >= 0 && 시간 <= 6) {
			System.err.println("구입 가능한 시간이 아닙니다.");
		}
		 
		// 2. (구입불가) 토요일이면서, 오후 8시 이후
		else if(todayOfWeek.equals("토") && ampm == 1 && 시간 >= 8) {
			System.err.println("구입 가능한 시간이 아닙니다.");
		}
		
		// 3. (구입가능)
		else {
			buyYn = true;
		}
		 
		// 구입 가능
		if(buyYn) {
			// 추첨일을 구하는 계산
			lottoCal.add(Calendar.DATE, 7 - 요일);
			String 추첨일 = sdf.format(lottoCal.getTime());
			System.out.println("추첨일 : " + 추첨일);
		}
		else {
			System.err.println("구입 가능한 시간에 다시 오세요.");
		}
		
	}
}
