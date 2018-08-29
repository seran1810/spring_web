package kosta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.model.Board;
import kosta.model.BoardDao;

@Service
public class BoardService {
	
	private BoardDao dao;
	
	
    @Autowired
    public void setDao(BoardDao dao) {
		this.dao = dao;
	}

    public void insertBoardService(Board board){
    	dao.insertBoard(board);
    }


	public List<Board> listBoardService(){
	
		return dao.listboard();
	}
	
	public Board detailBoardService(int seq){
          return dao.detailBoard(seq);
	}

}
