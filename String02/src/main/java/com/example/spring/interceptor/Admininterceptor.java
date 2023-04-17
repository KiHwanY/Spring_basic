package com.example.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Admininterceptor  extends HandlerInterceptorAdapter{
		
	
		//선처리
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession session = request.getSession();
			if(session.getAttribute("admin_userid") == null) {
				//관리자 로그인
				response.sendRedirect(request.getContextPath()+"admin/login.do?message==nologin");
				return false;
			}else {
				return true;
			}
		}
		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		super.postHandle(request, response, handler, modelAndView);
		}
}
