package com.aloha.spring.common.aop;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy	// 스프링에서 AspectJ 프록시를 활성화하는 어노테이션
@Component				// 스프링 빈 등록
@Aspect					// AOP 에서 횡단 관심사로 지정하는 어노테이션 - 어드바이스, 포인트 컷 등 사용 가능
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	/**
	 * 어드 바이스 - 
	 * 어드 바이스 유형
	 * - Around
	 * - Before
	 * - After
	 * - AfterReturning
	 * - AfterThrowing
	 */
	
	/**
	 * 포인트컷 표현요소
	 * - 지시자 : execution
	 * - 반환값  
	 * - 패키지
	 * - 클래스
	 * - 메소드
	 * - 인수
	 */
	@Before("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void before(JoinPoint jp) {
		// jp.getSignature() 	: 타겟 메소드의 시그처 정보(반환타입 패키지.클래스.메소드) 반환
		// jp.getArgs() 		: 타겟 메소드의 매개변수를 반환
		logger.info("===================================================================");
		logger.info("[@Before] #########################################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()) );
		
		// 파라미터 출력
		printParam(jp);
		logger.info("===================================================================\n");
	}
	
	
	@After("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void after(JoinPoint jp) {
		logger.info("===================================================================");
		logger.info("[@After] ##########################################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()) );
		
		// 파라미터 출력
		printParam(jp);
	    logger.info("===================================================================\n");
	}
	
	/*
	 * @Around 유형을 적용하면, @After 어드바이스는 실행되지 않는다.
	 * 
	 * ProceedingJoinPoint : 어드바이스에서 대상 메서드의 실행을 제어하고 호출하는 객체
	 * - proceed() 			: 대상 메소드 호출
	 */
	@Around("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		logger.info("===================================================================");
		logger.info("[@Around] #########################################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()) );
		LocalDateTime time = LocalDateTime.now();
		logger.info("현재 시간 : " + time);
		
		Object result = null;
		try {
			result = jp.proceed();
			if( result != null )
				logger.info("반환값 : " + result.toString());
		} catch (Throwable e) {
			logger.error("예외가 발생했습니다.");
			e.printStackTrace();
		}
		
		// After, Around 를 함께 사용하려면, Around 어드바이스  에서 After 어드바이스를 호출해준다.
		after(jp);
		logger.info("===================================================================\n");
		return result;
	}
	
	
	
	// pointcut 	: 포인트컷 표현식
	// returning 	: 타겟 메소드의 반환값을 저장하는 매개변수명 지정
	@AfterReturning(pointcut = "execution(* com.aloha.spring.service.BoardServiceImpl.*(..))", returning = "result")
	public Object afterReturning(JoinPoint jp, Object result) {
		logger.info("===================================================================");
		logger.info("[@AfterReturning] #################################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info("args : " + Arrays.toString(jp.getArgs()) );
		// 파라미터 출력
		printParam(jp);
		
		// 반환값 출력
		if( result != null )
			logger.info("반환값 : " + result.toString());
		
		logger.info("===================================================================\n");
		return result;
	}
	
	
	@AfterThrowing(pointcut = "execution(* com.aloha.spring.service.BoardService*.*(..))", throwing ="exception")
	public void afterThrowing(JoinPoint jp, Exception exception) {
		logger.info("===================================================================");
		logger.info("[@AfterThrowing] ##################################################");
		logger.info("target : " + jp.getTarget().toString());
		logger.info("signature : " + jp.getSignature());
		logger.info( exception.toString() ); 
		logger.info("===================================================================\n");
	}
	

	/**
	 * 파라미터 출력
	 * @param jp
	 */
	public void printParam(JoinPoint jp) {
		Signature signature = jp.getSignature();
	    // 타겟 메소드의 파라미터 이름 가져오기
	    String[] parameterNames = ((MethodSignature) signature).getParameterNames();
	    // 타겟 메소드의 인수 가져오기
	    Object[] args = jp.getArgs();
	    // 파라미터 이름과 값을 출력
	    if( parameterNames != null )
	    for (int i = 0; i < parameterNames.length; i++) {
	        String paramName = parameterNames[i];
	        Object paramValue = args[i];
	        logger.info("파라미터명: " + paramName + ", 값: " + paramValue);
	    }
	}

}