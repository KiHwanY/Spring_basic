package com.example.spring.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.model.board.dto.BoardDTO;
import com.example.spring.service.board.BoardService;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Inject
	BoardService boardService;
	
	//로깅을 위한 변수
	private static final Logger logger=
			LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("list.do") // 세부 url
	public ModelAndView list() throws Exception{
		List<BoardDTO> list=boardService.listAll();
		logger.info(list.toString());
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list); // map에 자료 저장
		map.put("count", list.size()); //레코드 갯수 파악
		mav.setViewName("board/list"); // 포워딩 뷰
		mav.addObject("map",map); //전달 데이터
		return mav;
	}
	@RequestMapping("write.do")
	public String write() {
		//글쓰기 폼 페이지 이동
		return "board/write";
	}
	@RequestMapping("insert.do") //@ModelAttribute 생략 가능
	public String insert(@ModelAttribute BoardDTO dto, HttpSession session) throws Exception{
		//이름이 없기 때문에 대신 세션에서 사용자 id 를 가져옴
		String writer = (String)session.getAttribute("userid");
		dto.setWriter(writer);
		//레코드 저장
		boardService.create(dto);
		//게시물 목록 이동
		return "redirect:/board/list.do";
	}
	
}
