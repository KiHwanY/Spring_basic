package com.example.spring.service.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring.model.member.dao.MemberDAO;
import com.example.spring.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		
		return false;
	}

	@Override
	public void logout(HttpSession session) {
		

	}

	@Override
	public MemberDTO viewMember(String userid) {
		
		return null;
	}

}
