package com.example.spring.service.board;

import java.util.List;

import com.example.spring.model.board.dto.ReplyDTO;

public interface ReplyService {
	
	public List<ReplyDTO> list(int bno);
	public int count(int bno);
	public void create(ReplyDTO dto);
	

}
