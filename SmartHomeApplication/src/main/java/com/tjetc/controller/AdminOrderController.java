package com.tjetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Orderitem;
import com.tjetc.domain.Orders;
import com.tjetc.service.OrderService;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/list")
	public String list(String orderId,String curPage,Model model) {
		orderId = orderId==null?"":orderId;
		System.out.println(orderId);
		System.out.println(curPage);
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<Orders> pageInfo = orderService.list(orderId,currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		model.addAttribute("orderId",orderId);
		return "admin/order/list";
	}
	
	@RequestMapping("/findOrderItem")
	public String findOrderItem(String id,Model model) {
		List<Orderitem> list = orderService.list(id);
		model.addAttribute("list",list);
		return "admin/order/orderItem";
	}
	
	@RequestMapping("/send/{id}")
	public String send(@PathVariable("id") String id) {
		orderService.updateState(id, 3);
		return "redirect:/adminOrder/list";
	}
	
	
}
