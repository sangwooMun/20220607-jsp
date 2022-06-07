package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.studentVO;

public interface StudentMapper {
	List<studentVO> studentSelectList(); // 전체리스트
	studentVO studentSelect(studentVO vo); // 한명조회
	
	int studetInsert(studentVO vo); //추가
	int studetUpdate(studentVO vo); // 변경
	int studetDelete(studentVO vo); // 삭제
}
