package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Service //현재 클래스를 스프링에서 관리하는 service bean으로 설정
// 1개의 Service 가 1개 또는 여러개의 dao를 다룬다.
public class MemberServiceImpl implements MemberService {
	//dao 인스턴스 주입
	@Inject
	MemberDAO memberdao;
	
	@Override
	public List<MemberDTO> memberList() {
		
		return memberdao.memberList();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberdao.insertMember(dto);

	}

	@Override
	public MemberDTO viewMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkPw(String userid, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
