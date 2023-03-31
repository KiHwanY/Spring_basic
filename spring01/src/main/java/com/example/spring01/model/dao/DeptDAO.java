package com.example.spring01.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.model.dto.DeptVO;

//@Resource 에서 name 을 deptDao로 연결 요청 했기 때문에 아래처럼 이름을 기입
@Repository("deptDao")
public class DeptDAO {
	
	@Inject
	SqlSession sqlSession;
	
	public List<DeptVO> deptList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("dept.deptList");
	}
}
