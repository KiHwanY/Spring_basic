package com.example.spring.model.admin.dao;

import com.example.spring.model.member.dto.MemberDTO;

public interface AdminDAO {
	// 별도로 AdminDTO를 만들지 않고 멤버 변수이름이 똑같거나 해서 MemberDTO를 재활용
	public String loginCheck(MemberDTO dto);
	
}
