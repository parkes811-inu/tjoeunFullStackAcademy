package sample;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
//@WebServlet("/board/update")
public class AServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	/*
    	 *  forward 방식으로 페이지 이동
    	 * */
//        // 루트 경로로 요청을 전달할 URL 설정
//        String targetURL = "/BServlet";    // 포워드 방식으로 이동할 경로
//
//        // RequestDispatcher를 얻어옴
//        RequestDispatcher dispatcher = request.getRequestDispatcher(targetURL);
//       
//        System.out.println("AServlet -> BServlet으로 forward");
//        
//        // RequestDispatcher를 사용하여 요청 및 응답을 다른 서블릿 또는 JSP 페이지로 전달
//        dispatcher.forward(request, response);
    	
    	/*
    	 * 리다이렉트를 수행하고 /board/list 경로로 이동
    	 * */
    	
    	

    	//@WebServlet("/board/update")

        // 리다이렉트를 수행하고 /board/list 경로로 이동
        response.sendRedirect(request.getContextPath() + "/board/list");
    	    }
    	}
    }
}
