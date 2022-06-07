package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 처리하는 곳
 */
@WebServlet("*.do") // "/*" = 모든 요청은 여기서 받는다 do는 관례적
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 맵 컬렉션을 이용해 요청
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
       
    public FrontController() {
        super();
    }

	/**
	 * 요청과 처리 명령를 연결하는 부분
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/test.do", new TestCommand());
		map.put("/memberList.do", new MemberListCommand()); // 학생목록
	}

	/**
	 * 여기서 들어온 요청을 분석하고 명령을 실행해서 결과를 돌려보내주는 곳
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		String uri = request.getRequestURI();// 먼저 uri를 구하고 // 요청 URI 구함
		String contextPath = request.getContextPath(); // 루트 디렉토리 정보 // 컨텍트패스
		String page = uri.substring(contextPath.length()); // 실제 요청 명령을 받는다(페이지)
		
		Command command = map.get(page); // 실행할 명령객체를 찾기
		String viewPage = command.exec(request, response); // 명령을 실행하고 결과를 돌려받는다
		
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) { // viewResolve
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		}
		
		// 결과 페이지를 돌려준다.
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 보여줄 페이지 값
		dispatcher.forward(request, response); // 보여줄 페이지 던저줌
	}

}
