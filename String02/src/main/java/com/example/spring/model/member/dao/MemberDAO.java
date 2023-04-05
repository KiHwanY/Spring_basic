package com.example.spring.model.member.dao;

import com.example.spring.model.member.dto.MemberDTO;

public interface MemberDAO {
	
		public boolean loginCheck(MemberDTO dto);
		public MemberDTO viewMember(String userid);
		

}
