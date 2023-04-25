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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.model.board.dto.BoardDTO;
import com.example.spring.service.board.BoardService;
import com.example.spring.service.board.Pager;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Inject
	BoardService boardService;
	
	//로깅을 위한 변수
	private static final Logger logger=
			LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("list.do") // 세부 url
	//defaultValue = "1" : 파라미터가 없을 때 1로 셋팅해줌
	public ModelAndView list(@RequestParam(defaultValue = "1") int curPage) throws Exception{
		//레코드 개수 계산
		int count = boardService.countArticle();
		// 페이지 관련 설정
		Pager pager = new Pager(count, curPage);
		int start=pager.getPageBegin();
		int end =pager.getPageEnd();
		
		List<BoardDTO> list=boardService.listAll(start,end); // 게시물 목록
		logger.info(list.toString());
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list); // map에 자료 저장
		map.put("count",count); //레코드 갯수 파악
		map.put("pager", pager); // 페이지 네비게이션을 위한 변수
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
	@RequestMapping("view.do")
	public ModelAndView view(int bno, HttpSession session) throws Exception{
		//조회수 증가 처리
		boardService.increaseViewcnt(bno, session);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", boardService.read(bno)); // 자료 저장
		return mav;
		
	}
	//첨부파일 목록을 리턴
	// ArrayList 를 json 배열로 변환하여 리턴
	@RequestMapping("getAttach/{bno}")
	@ResponseBody // view 가 아닌 List<String> 데이터 자체를 리턴
	public List<String> getAttach(@PathVariable int bno){
		return boardService.getAttach(bno);
	}
	//게시물 내용 수정
	@RequestMapping("update.do")
	public String update(BoardDTO dto) throws Exception{
		System.out.println("dto : "+dto);
		if(dto != null) {
			boardService.update(dto);
		}
		//목록으로 이동
		/*
		 * return "redirect:/board/list.do;
		 */
		//상세 화면으로 되돌아가기
		return "redirect:/board/view.do?bno="+dto.getBno();
	}
	
}
