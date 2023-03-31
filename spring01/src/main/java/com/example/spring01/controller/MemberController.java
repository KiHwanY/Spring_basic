package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller //스프링에서 관리하는 컨트롤러 빈으로 등록
public class MemberController {
	
	//MemberService 인스턴스 주입
	@Inject
	MemberService memberService;
	
	@RequestMapping("member/list.do") //url mapping
	public String memberList(Model model) {
		List<MemberDTO> list=memberService.memberList();
		model.addAttribute("list", list);
		return "member/member_list";
	}
	
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}

	//@ModelAttribute : 폼에서 전달된 값을 저장하는 객체(생략 가능)
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		System.out.println(dto);
		memberService.insertMember(dto);
		return "redirect:/member/list.do";//리스트 갱신요청
	}
	
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		//모델에 자료 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
	public String update(MemberDTO dto, Model model) {
		//비밀번호 체크
		boolean result=memberService.checkPw(dto.getUserid(), dto.getPasswd());
		if(result) {//비번이 맞으면
			//회원정보 수정
			memberService.updateMember(dto);
			return "redirect:/member/list.do";//리스트 갱신요청
		}else {//비번 틀리면
			model.addAttribute("message", "비밀번호를 확인하세요.");
			//수정버튼을 누른 후에는 입력필드의 값들이 지워지기 때문에 이를 방지하기 위해
			model.addAttribute("dto",dto);
			//날짜는 dto가 아닌 시스템에서 자동처리했기에 날짜도 입력필드에서 지워지는 현상을 방지
			model.addAttribute("join_date", 
					memberService.viewMember(dto.getUserid()).getJoin_date());
			return "member/view";
		}
	}
	
	@RequestMapping("member/delete.do")
	public String delete(String userid, String passwd, Model model) {
		boolean result=memberService.checkPw(userid, passwd);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
		}else {
			model.addAttribute("message", "비밀번호를 확인하세요.");
			model.addAttribute("dto", memberService.viewMember(userid));
			return "member/view";
		}
	}
	
}
