package co.micol.prj.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.DataSource;
import co.micol.prj.student.service.StudentMapper;
import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.studentVO;

public class StudentServiceImpl implements StudentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
	
	@Override
	public List<studentVO> studentSelectList() {
		return map.studentSelectList();
	}

	@Override
	public studentVO studentSelect(studentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studetInsert(studentVO vo) {
		return map.studetInsert(vo);
	}

	@Override
	public int studetUpdate(studentVO vo) {
		return map.studetUpdate(vo);
	}

	@Override
	public int studetDelete(studentVO vo) {
		return map.studetDelete(vo);
	}

}
