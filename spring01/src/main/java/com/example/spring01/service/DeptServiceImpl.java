package com.example.spring01.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.spring01.model.dao.DeptDAO;
import com.example.spring01.model.dto.DeptVO;

@Service
public class DeptServiceImpl implements DeptService {
	
	//@Inject 대신 @Resource 를 쓸 수 있다.
	//차이점은 Inject는 연결 방식이 Type 이지만 Resource는 Name 방식이다.
	
	@Resource(name  =  "deptDao")
	private DeptDAO deptDao;
	
  
	
	@Override
	public List<DeptVO> deptList() {
		
		return deptDao.deptList();
	}

}
