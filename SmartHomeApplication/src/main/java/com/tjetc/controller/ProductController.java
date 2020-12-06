package com.tjetc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Category;
import com.tjetc.domain.Product;
import com.tjetc.service.AdminCategoryService;
import com.tjetc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired 
	private AdminCategoryService adminCategoryService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		List<Product> hotList = productService.hotList();
		List<Product> newsList = productService.newsList();
		model.addAttribute("hotlist",hotList);
		model.addAttribute("newslist",newsList);
		return "jsp/list";
	}
	
	@ModelAttribute("categories")
	public List<Category> categories(HttpSession session){
		List<Category> list = adminCategoryService.list();
		session.setAttribute("categories", list);
		return list;
	}
	
	@RequestMapping("list")
	public String list(String curPage, Integer cid, Integer scid, Model model) {
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 6;
		PageInfo<Product> pageInfo = productService.list(cid, scid, currentPage, pageSize);
		model.addAttribute("page",pageInfo);
		model.addAttribute("cid",cid);
		model.addAttribute("scid",scid);
		return "jsp/productList";
	}
	
	@RequestMapping("/show")
	public String show(Integer id, Model model) {
		Product product = productService.getById(id);
		model.addAttribute("product",product);
		return "jsp/product";
	}
	
}
