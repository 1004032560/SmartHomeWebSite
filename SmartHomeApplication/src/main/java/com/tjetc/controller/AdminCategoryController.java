package com.tjetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Category;
import com.tjetc.service.AdminCategoryService;

@Controller
@RequestMapping("/adminCategory")
public class AdminCategoryController {

	@Autowired
	private AdminCategoryService adminCategoryService;
		
	@RequestMapping("/list")
	public String list(String name,String curPage,Model model) {
		name = name==null?"":name;
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<Category> pageInfo = adminCategoryService.list(name,currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		model.addAttribute("name",name);
		return "admin/category/list";
	}
	
	@RequestMapping("/del")
	public String del(String id) {
		adminCategoryService.del(Integer.parseInt(id));
		return "redirect:/adminCategory/list";
	}
	
	@RequestMapping("/validName")
	@ResponseBody
	public boolean validName(String name) {
		Category category = adminCategoryService.getByName(name);
		return category==null;
	}
	
	@RequestMapping("/add")
	public String add(String name) {
		Category category = new Category();
		category.setName(name);
		adminCategoryService.add(category);
		return "redirect:/adminCategory/list";
	}
	
	@RequestMapping("/getById")
	public String getById(String id,Model model) {
		Category category = adminCategoryService.getById(Integer.parseInt(id));
		model.addAttribute("category",category);
		return "admin/category/edit";
	}
	
	@RequestMapping("/update")
	public String update(String id, String name) {
		Category category = new Category();
		category.setId(Integer.parseInt(id));
		category.setName(name);
		adminCategoryService.update(category);
		return "redirect:/adminCategory/list";
	}
	
}