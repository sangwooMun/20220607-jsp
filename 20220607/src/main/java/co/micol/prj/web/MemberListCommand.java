package co.micol.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.serviceImpl.StudentServiceImpl;
import co.micol.prj.student.vo.studentVO;

public class MemberListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// DB 처리하는 부분
		// 보여줄 페이지에 값을 싫고
		StudentService dao = new StudentServiceImpl();
		List<studentVO> students = new ArrayList<studentVO>();
		students = dao.studentSelectList();
		request.setAttribute("students", students); // 실행내역 객체 담기
		return "member/member";
	}

}
