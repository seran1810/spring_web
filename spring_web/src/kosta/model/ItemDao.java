package kosta.model;

import kosta.mapper.OrderMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}	

	public void updateItem(Order order){  //재고수정
		myTemplate.getMapper(OrderMapper.class).updateItem(order);
	}
	
	public Item findItem(String no){  //재고수량
		return myTemplate.getMapper(OrderMapper.class).findItem(no);
	}
}















