package kosta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.model.Board;
import kosta.service.BoardService;

@RestController
public class JsonController1 {

	private BoardService service;

	@Autowired
	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping("spring_json1")
	public List<Board> spring_json1() {

		List<Board> list = service.listBoardService();
		System.out.println(2);
		return list;
	}

}
