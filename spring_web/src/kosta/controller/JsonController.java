package kosta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Member;

@RestController //json���� ����� ���� ��Ʈ�ѷ�
public class JsonController {
	
	@RequestMapping("spring_json")
	
	public List<Member> spring_json(){
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("ȫ�浿", "aa@aa.com"));
		list.add(new Member("�ڱ浿", "bb@bb.com"));
		System.out.println(3);
		return list;
	}

}
