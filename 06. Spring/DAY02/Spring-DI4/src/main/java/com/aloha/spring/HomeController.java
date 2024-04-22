package com.aloha.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aloha.spring.dao.ReplyDAO;
import com.aloha.spring.service.BoardService;
import com.aloha.spring.service.MyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 의존성 자동 주입
	@Autowired
	@Qualifier("AServiceImpl")
	private MyService myService;
	
	@Autowired
	@Qualifier("BServiceImpl")
	private MyService myService2;
	
	@Autowired
	@Qualifier("C")
	private MyService myService3;
	
	@Autowired
	private BoardService boardServcie;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		myService.test();
		//myService2.test();
		//myService3.test();
		
		//boardServcie.test();
		//boardServcie.setBoardDAO( replyDAO );
		//boardServcie.test();
		
		return "home";
	}

}
