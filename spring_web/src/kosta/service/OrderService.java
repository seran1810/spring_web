package kosta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import kosta.model.ItemDao;
import kosta.model.Order;
import kosta.model.OrderDao;
@Service
public class OrderService {
	private OrderDao orderDao;
	private ItemDao itemDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRED , rollbackFor={Exception.class}) //propagation
	public void OrderAction(Order order)throws Exception{
		System.out.println(1);
		orderDao.addOrder(order); //주문 처리
		
		if(itemDao.findItem(order.getNo()).getAmount() < order.getAmount()){
			throw new Exception("재고부족");
		}
		itemDao.updateItem(order); //재고수량 조정
	}
		

}
