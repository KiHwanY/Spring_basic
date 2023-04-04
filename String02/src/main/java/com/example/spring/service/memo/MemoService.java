package com.example.spring.service.memo;

import java.util.List;

public interface MemoService {
	
	public List<com.example.spring.model.memo.dto.MemoDTO> list();
	public void insert(com.example.spring.model.memo.dto.MemoDTO dto); // 추가
	public com.example.spring.model.memo.dto.MemoDTO memo_view(int idx); // 목록
	public void update(com.example.spring.model.memo.dto.MemoDTO dto); // 수정
	public void delete(int idx); // 삭제
	
	
}
