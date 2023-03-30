package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller //스프링에서 관리하는 컨트롤러 빈으로 등록
public class MemberController {
	
	//MemberService 인스턴스 주입
	@Inject
	MemberService memberservice;
	
	@RequestMapping("member/list.do") //url mapping
	public String memberList(Model model) {
		List<MemberDTO> list = memberservice.memberList();
		model.addAttribute("list",list);
		
		return "member/member_list";
	}
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		System.out.println(dto);
		memberservice.insertMember(dto);
		return "redirect:/member/list.do"; //리스트 갱신
	}
	
}
