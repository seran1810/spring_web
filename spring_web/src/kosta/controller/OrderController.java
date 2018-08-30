package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.model.Order;
import kosta.service.OrderService;

@Controller
public class OrderController {
	
	private OrderService service;

	@Autowired
	public void setService(OrderService service) {
		this.service = service;
	}
	
	@RequestMapping("/orderForm")
	public String orderForm(){
		return "transaction/orderForm";
	}
	
	@RequestMapping("/order")
	public String orderDao(Order order){
		System.out.println(2);
		String view ="transaction/orderOk";
		
		try {
			System.out.println(3);
			service.OrderAction(order);
			
		} catch (Exception e) {
			System.out.println("¿À·ù");
			view="transaction/orderForm";
		}
		return view;
	}

}
