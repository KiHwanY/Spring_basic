package com.example.spring.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring.model.member.dto.MemberDTO;
import com.example.spring.service.member.MemberService;
import com.example.spring.service.memo.MemoService;

@Controller
@RequestMapping("member/*") //공통 url
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject //DI
	MemberService memberService;
	
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public ModelAndView login_check(MemberDTO dto, HttpSession session) {
		//로그인 성공 true, 실패 false
		
		boolean result = memberService.loginCheck(dto, session);
		
		ModelAndView mav = new ModelAndView();
		
		if(result) { // 로그인 성공
			mav.setViewName("home");
		}else {
			mav.setViewName("member/login");
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	
	
	
}
