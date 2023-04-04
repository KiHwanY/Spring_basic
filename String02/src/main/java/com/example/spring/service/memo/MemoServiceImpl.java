package com.example.spring.service.memo;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;



@Service
public class MemoServiceImpl implements MemoService {
	
	//Service 가 DAO를 호출
	@Inject // DI(의존관계 주입)
	com.example.spring.model.memo.dao.MemoDAO memoDao;

	@Override
	public List<com.example.spring.model.memo.dto.MemoDTO> list() {
	
		return memoDao.list(); // list()는 완성된 인터페이스가 아닌데도
		// 쓸 수 있는 이유는 스프릥이 root-context.xml 에서 지정한 mybatis 객체를
		// 메모리에 올려 셋팅에 의해 생성된 객체를 자동 결합시키며 ArrayList 로 받아 처리한다.
	}

	@Override
	public void insert(com.example.spring.model.memo.dto.MemoDTO dto) {
		memoDao.insert(dto.getWriter(), dto.getMemo());

	}

	@Override
	public com.example.spring.model.memo.dto.MemoDTO memo_view(int idx) {
		
		return memoDao.memo_view(idx);
	}

	@Override
	public void update(com.example.spring.model.memo.dto.MemoDTO dto) {
		memoDao.update(dto);

	}

	@Override
	public void delete(int idx) {
		memoDao.delete(idx);
	}

}
