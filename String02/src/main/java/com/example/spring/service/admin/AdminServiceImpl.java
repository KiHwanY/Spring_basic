package com.example.spring.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring.model.admin.dao.AdminDAO;
import com.example.spring.model.member.dto.MemberDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	AdminDAO adminDao;
	

	@Override
	public String loginCheck(MemberDTO dto) {
		
		return adminDao.loginCheck(dto);
	}

}
