package com.tjetc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tjetc.domain.Cart;
import com.tjetc.domain.CartItem;
import com.tjetc.domain.Category;
import com.tjetc.domain.Product;
import com.tjetc.service.AdminCategoryService;
import com.tjetc.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private AdminCategoryService adminCategoryService;
	
	@ModelAttribute("categories")
	public List<Category> categories(){
		return adminCategoryService.list();
	}
	
	@RequestMapping("/add")
	public String add(int count, int id,HttpSession session, Model model) {
		//通过id获取product
		Product product = productService.getById(id);
		//从session获取cart
		Cart cart = getCart(session);
		//创建CartItem对象
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setCount(count);
		//添加购物车
		cart.addCart(cartItem);
		return "jsp/cart";
	}

	@RequestMapping("removeCart")
	public String removeCart(int id,HttpSession session, Model model) {
		Cart cart = getCart(session);
		cart.removeCart(id);
		return "jsp/cart";
	}
	
	@RequestMapping("clearCart")
	public String clearCart(HttpSession session, Model model) {
		Cart cart = getCart(session);
		cart.clearCart();
		return "jsp/cart";
	}
	
	private Cart getCart(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart==null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}
	
}