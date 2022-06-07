package co.micol.prj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/First") // 어노테이션 메핑방법
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public First() {
        super();
    }
    // www.naver.com?id~~ pass~~ @:주소 뒤(com) 변수값이 나오는게 GET방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); // 결과 불러오기 request = 요청값
		out.print("<h1>Hello sangwoo</h1>");
	}
	// form 객체(테그)를 던지는 것 = post 방식
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
