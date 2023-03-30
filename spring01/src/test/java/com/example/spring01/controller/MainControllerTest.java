package com.example.spring01.controller;



import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MainControllerTest {
	@Inject //의존관계 주입(DI), 제어권 역전(IoC)
	WebApplicationContext wac;
	
	MockMvc mockMvc; // 모조  mvc 테스트 
	
	@Before 
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
	
	
	//JUnit이 테스트하는 코드
	@Test
	public void testMain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}

	@Test
	public void testGugu() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/gugu.do"));
	}

	@Test
	public void testTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test.do"));
	}

	@Test
	public void testDaA() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doA"));
	}

	@Test
	public void testDaB() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doB"));
	}

	@Test
	public void testDoC() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doC"));
	}

	@Test
	public void testDoD() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doD"));
	}

	@Test
	public void testDoE() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doE"));
	}

}
