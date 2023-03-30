package com.example.spring01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



//Controller 임을 스프링에게 등록 
@Controller
public class MainController {
	private static final Logger logger =  LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	// Model에 자료 저장(서블릿의 request 객체에 해당됨)
	public String main(Model model) {
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		// WEB-INF/views/main.jsp 포워딩
		return "main";
	}
	
	@RequestMapping("gugu.do") //url mapping
	public String gugu(Model model, @RequestParam(defaultValue="2") int dan) {
		//int dan = 7;
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan+"x"+i+"="+dan*i+"<br>";
		}
		//모델에 자료 저장
		model.addAttribute("result",result);
		// views/test/gugu.jsp로 포워딩
		return "test/gugu";
	}
	
	@RequestMapping("test.do")
	public void test() {
		//리턴 타입의 void인 경우는 요청 url의 .do를 제외한 test라는 이름과 같은 페이지로 포워딩 
		//  WEB-INF/views/test.jsp
	}
	@RequestMapping("test/doA")
	public String daA(Model model) {
		//자료 저장
		model.addAttribute("message","홈페이지 방문을 환영합니다");
		//포워딩
		return "test/doA";
		
	}
}
