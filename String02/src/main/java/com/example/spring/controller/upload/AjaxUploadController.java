package com.example.spring.controller.upload;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring.util.UploadFileUtils;

@Controller
public class AjaxUploadController {
	// 로깅
	private static final Logger logger = LoggerFactory.getLogger(AjaxUploadController.class);
	
	//업로드 디렉토리
	@Resource(name ="uploadPath")
	String uploadPath;
	
	@RequestMapping(value = "upload/uploadAjax", method = RequestMethod.GET)
		public String uploadAjax() {
			return "upload/uploadAjax";
		}
	
	@ResponseBody // 객체를 json 형식으로 데이터 리턴(서버 -> 클라이언트)
	@RequestMapping(value = "/upload/uploadAjax" , method = RequestMethod.POST, produces = "text/plain;charset=utf-8") //한글이 깨지지 않도록 처리
	 // ResponseEntity : 업로드한 파일 정보와 Http 상태 코드를 함께 리턴
		public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.OK);
		
		
	}
	
	}
