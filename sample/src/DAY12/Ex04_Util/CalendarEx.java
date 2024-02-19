package DAY12.Ex04_Util;

//2024-02-19 
//MSA 기반 풀스택 교육 12일차

import java.util.Calendar;
import java.util.spi.CalendarNameProvider;

public class CalendarEx {
	public static void printCalendar(String msg, Calendar cal) {
		int year = cal.get( Calendar.YEAR );
		int month = cal.get( Calendar.MONTH ) + 1;			// 월(0~11)
		int day = cal.get( Calendar.DAY_OF_MONTH );
		int dayOfWeek = cal.get( Calendar.DAY_OF_WEEK );	// 일~토(1~7)
		int hour = cal.get( Calendar.HOUR );				// 12시 표시
		int hourOfDay = cal.get( Calendar.HOUR_OF_DAY );	// 24시 표시
		int ampm = cal.get( Calendar.AM_PM );
		int minute = cal.get( Calendar.MINUTE );
		int second = cal.get( Calendar.SECOND );
		int millisecond = cal.get( Calendar.MILLISECOND );
		System.out.print(msg + " : " + year + "/" + month + "/" + day +"/");
		
		// 일요일(1) ~ 토요일(7)
		String Day = "";
		switch (dayOfWeek) {
			case Calendar.SUNDAY:		Day = "일요일"; break;
			case Calendar.MONDAY:		Day = "월요일"; break;
			case Calendar.TUESDAY:		Day = "화요일"; break;
			case Calendar.WEDNESDAY:	Day = "수요일"; break;
			case Calendar.THURSDAY:		Day = "목요일"; break;
			case Calendar.FRIDAY:		Day = "금요일"; break;
			case Calendar.SATURDAY:		Day = "토요일"; break;
		}
		System.out.print(Day);
		
		// 시, 분, 초 출력
		System.out.print("(" + hourOfDay + "시)");
		if( ampm == Calendar.AM )
			System.out.print("오전 ");
		if( ampm == Calendar.PM )
			System.out.print("오후 ");
		
		System.out.println(hour + "시 " + minute + "분 " + second + "초 " + millisecond + "밀리초");
	}
	
	public static void main(String[] args) {
		// * new Calendar() 대신, getInstance() 메소드로 객체를 사용해야 한다.
		Calendar now = Calendar.getInstance();
		
		printCalendar("현재 : ", now);
		
		// 자바 프로그래밍 마지막 수업일
		Calendar test = Calendar.getInstance();
		test.set(2024, Calendar.FEBRUARY, 27);
		printCalendar("자바 마지막 수업일(년/월/일) : ", test);
		test.set(2024, Calendar.FEBRUARY, 27, 18, 30, 0);
		printCalendar("자바 마지막 수업일(년 ~ 초) : ", test);
		
		// 종강일 
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(2024, Calendar.AUGUST, 1, 18, 0, 0);
		printCalendar("종강일 : ", lastDay);
		
		// - lastDay 	: 종강일
		// - now		: 오늘 (날짜/시간)
		long lastT = lastDay.getTimeInMillis();
		long nowT = now.getTimeInMillis();
		
		// getTimeInMillis()	: 날짜를 ms(밀리초) 단위까지 숫자로 반환
		// 1970년 1월 1일 0시 0분 0초 0ms 부터 카운트한 숫자를 반환
		// 0.001초		: 1ms
		// 60초			: 1분
		// 60분			: 1시간
		// 24시			: 1일
		System.out.println("lastT - nowT = " + (lastT - nowT)); 
		
		long dDay = (lastT - nowT) / 1000 / 60 / 60 / 24;
		System.out.println("D-day : " + dDay + "일");
		
		long nowD = nowT / (1000 * 60 * 60 * 24);
		long lastD = lastT / (1000 * 60 * 60 * 24);
		System.out.print("1970년 1월 1일 0시 0분 0초 0ms ~ 오늘까지 일 수 : ");
		System.out.println(nowD + "일");
		
		System.out.print("1970년 1월 1일 0시 0분 0초 0ms ~ 종강까지 일 수 : ");
		System.out.println(lastD + "일");
		
		// 내가 태어난 지 몇 일
		Calendar birth = Calendar.getInstance();
		birth.set(1997, Calendar.AUGUST, 11, 13, 0, 0);		// 생일 지정
		long birthD = birth.getTimeInMillis() / (1000 * 60 * 60 * 24);
		long afterBirth = nowD - birthD;
		System.out.println("생후 " + afterBirth + "일이 지났습니다.");
		System.out.println(afterBirth / 365);
		
		// * 월(MONTH)는 0 ~ 11로 0이 1월을 의미하므로, + 1을 하거나,  
		// Calendar. 으로 월을 지정해줘야 한다.

		if(now.before(lastDay)) {
			System.out.println("종강 전 입니다.");
		}
		else if(now.after(lastDay)) {
			System.out.println("수업이 종료된 강의입니다.");
		}
	}
}
