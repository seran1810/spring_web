package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.service.HelloService;


@Controller
public class HelloController {
	@Autowired

	private HelloService service;


	public HelloController() {
	
		
	}
	 
	public HelloController(HelloService service) {
		
		this.service = service;
	}

	
@RequestMapping("/hello.do")
	
public ModelAndView hello() {

	
	ModelAndView mav = new ModelAndView();
	mav.addObject("message", service.getMessage()); // 데이터 가저가기위해 - 키, 벨류
	mav.setViewName("hello"); // 뷰이름 정하기
		
	return mav;
}

/*@RequestMapping("/hello.do")     //2번째 String 방식
public String hello(Model model) {

    model.addAttribute("message",service.getMessage());
		
	return "hello";
}*/


@RequestMapping("/spring_client") 
public String spring_client(){
	return "client";
}

}
