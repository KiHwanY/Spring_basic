package com.example.spring.model.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name = sqlSession.selectOne("member.login_check", dto);
		
		// 조건식 ? true : false 값
		return (name == null) ? false : true;
	}

	@Override
	public MemberDTO viewMember(String userid) {
		
		return sqlSession.selectOne("member.viewMember", userid);
	}

}
