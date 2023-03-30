package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;



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
	@RequestMapping("/test/doB")
	public void daB(){
		// void일 때 doB.jsp로 자동 포워딩
		logger.info("doB 호출");
		
	}
	// Model - 전달할 데이터 
	// ModelAndView - 데이터와 포워딩할 페이지 정보 포함
	@RequestMapping("/test/doC")
	public ModelAndView doC() {
			Map<String, Object> map = new HashMap<>();
			map.put("product", new ProductDTO("샤프", 1000));
			
			// ModelAndView("페이지이름","키변수",값)
			// views/test/doC.jsp 포워딩
			return new ModelAndView("test/doC","map",map);
	}
	@RequestMapping("/test/doD")
	public String doD() {
		//forward : 기본(주소 그대로)
		//redirect : 따로 정의해서 화면이동(주소 변경)
		return "redirect:/test/doE";
	}
	@RequestMapping("test/doE")
	public void doE() {
		//void 이기 때문에 자동적으로 doE.jsp로 포워딩
		
	}
	//@RestController - 스프링 4.0이상 부터 사용 가능(호환성 주의)
	/*
	 * @ResponseBody //자바 객체인 dto를 json 으로 변환 (호환성 상관없음)
	 * 
	 * @RequestMapping("test/doF") public ProductDTO doF() { // 뷰를 리턴하는 것이 아닌 데이터
	 * 자체를 리턴하는 경우 return new ProductDTO("냉장고",500000); //여기서 doF()는 ProductDTO 인
	 * dto 자체를 test.jsp에 보내게 되는데 //받는 쪽 입장에서 자바 스크립트는 success: function(result) { 의
	 * "result"는 //json형식(xml)으로 받아처리 해야하기 때문에 별도의 변환기가 필요하다. }
	 */
}
