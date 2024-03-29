package session;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

// 사용자의 세션에 대한 행위를 인식하는 클래스
// 서블릿 3.0 이상이면 어노테이션으로 리스너를 등록가능
// 서브릿 3.0 미만이면 web.xml 에 설정
@WebListener		
public class SessionListener implements HttpSessionListener {

	// 세션이 생성될 때 실행
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("세션이 생성됨...");
		
		ServletContext application = event.getSession().getServletContext();
		AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
		if( visitorCount == null ) {
			visitorCount = new AtomicInteger(0);
			application.setAttribute("visitorCount", visitorCount);
		}
		// 세션 생성 시, 접속자 수 1 증가
		int currentCount = visitorCount.incrementAndGet();
		System.out.println("현재 접속자 수 : " + currentCount);
	}

	// 세션이 종료될 때 실행
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// 세션 종료 시 application 객체에서 접속자 수를 감소시킴
		ServletContext application = event.getSession().getServletContext();
		AtomicInteger visitorCount = (AtomicInteger) application.getAttribute("visitorCount");
		int count = 0;
		if( visitorCount != null ) {
			count = visitorCount.decrementAndGet();
			System.out.println("접속자 수 -1");
		}
		// 감소된 접속자 수로 재설정
		application.setAttribute("visitorCount", count);
		System.out.println("접속자 수 : " + count);
		
	} 
}






