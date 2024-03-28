package sample;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BServlet")
public class ResponseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		 
		// 응답의 콘텐츠 타입을 HTML로 설정
		response.setContentType("text/html");
		
		PrintWriter wirter = response.getWriter();
		wirter.println("BServlet 입니다.");
	}
}   


