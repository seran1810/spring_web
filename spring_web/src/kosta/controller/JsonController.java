package kosta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Member;

@RestController //json만을 만들기 위한 컨트롤러
public class JsonController {
	
	@RequestMapping("spring_json")
	
	public List<Member> spring_json(){
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동", "aa@aa.com"));
		list.add(new Member("박길동", "bb@bb.com"));
		System.out.println(3);
		return list;
	}

}
