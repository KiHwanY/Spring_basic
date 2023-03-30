package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

//RestController 는 뷰를 리턴하는 것이 아니라 json을 리턴 
@RestController
public class SampleRestController {
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		return new ProductDTO("세탁기", 100000);
	}
}
