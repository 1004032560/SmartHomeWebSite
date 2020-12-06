package com.tjetc.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Cart;
import com.tjetc.domain.CartItem;
import com.tjetc.domain.Orderitem;
import com.tjetc.domain.Orders;
import com.tjetc.domain.User;
import com.tjetc.service.OrderService;
import com.tjetc.service.OrderitemService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderitemService orderitemService;
	
	@RequestMapping("/saveOrder")
	public String saveOrder(HttpSession session,Model model) {
		Cart cart = (Cart)session.getAttribute("cart");
		System.out.println("cart="+cart.getTotal());
		User user = (User)session.getAttribute("user");
		System.out.println("user="+user.getUsername());
		Orders orders = new Orders();
		//orderµÄid
		int random = (int)((Math.random()*9+1)*100000);
		Date date = new Date();
		String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
		
		orders.setId(random+format);
		orders.setAddr(user.getAddr());
		orders.setName(user.getName());
		orders.setOrdertime(date);
		orders.setPhone(user.getPhone());
		orders.setState(1);
		orders.setTotal(cart.getTotal());
		orders.setUid(user.getId());
		
		Collection<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			System.out.println(cartItem);
			Orderitem orderitem = new Orderitem();
			orderitem.setCount(cartItem.getCount());
			orderitem.setProductId(cartItem.getProduct().getId());
			orderitem.setOrderId(random+format);
			orderitem.setProduct(cartItem.getProduct());
			orderitem.setSubtotal(cartItem.getSubtotal());
			System.out.println(orderitem);
			System.out.println(orders);
			orders.getOrderitems().add(orderitem);
			orderitemService.add(orderitem);
		}
		orderService.add(orders);
		session.removeAttribute("cart");
		model.addAttribute("order",orders);
		return "jsp/order";
	}
	
	@RequestMapping("/payOrder")
	public String payOrder(Orders orders,Model model) {
		orderService.update(orders);
		model.addAttribute("orders",orders);
		return "jsp/orderConfirm";
	}
	
	@RequestMapping("/list")
	public String list(HttpSession session,String curPage,Model model) {
		User user = (User)session.getAttribute("user");
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 4;
		PageInfo<Orders> pageInfo = orderService.list(user.getId(),currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		return "jsp/orderList";
	}
	
	@RequestMapping("/payMoney/{id}")
	public String payMoney(@PathVariable("id") String id) {
		orderService.updateState(id,2);
		return "redirect:/order/list";
	}
	
	@RequestMapping("/receive/{id}")
	public String receive(@PathVariable("id") String id) {
		orderService.updateState(id,4);
		return "redirect:/order/list";
	}
}
