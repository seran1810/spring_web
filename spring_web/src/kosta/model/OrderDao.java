package kosta.model;

import kosta.mapper.OrderMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}
	
	public void addOrder(Order order){  //주문테이블에 주문 추가
		myTemplate.getMapper(OrderMapper.class).addOrder(order);;
	}

}














