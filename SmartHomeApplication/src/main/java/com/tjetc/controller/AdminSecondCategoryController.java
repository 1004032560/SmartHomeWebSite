package com.tjetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Category;
import com.tjetc.domain.Secondcategory;
import com.tjetc.service.AdminCategoryService;
import com.tjetc.service.AdminSecondCategoryService;

@Controller
@RequestMapping("/adminSecondCategory")
public class AdminSecondCategoryController {

	@Autowired
	private AdminSecondCategoryService adminSecondCategoryService;
	
	@Autowired 
	private AdminCategoryService adminCategoryService;
		
	@RequestMapping("/list")
	public String list(String name, String curPage, Model model) {
		name = name==null?"":name;
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<Secondcategory> pageInfo = adminSecondCategoryService.list(name,currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		model.addAttribute("name",name);
		return "admin/secondcategory/list";
	}
	
	@RequestMapping("/del")
	public String del(String id) {
		adminSecondCategoryService.del(Integer.parseInt(id));
		return "redirect:/adminSecondCategory/list";
	}
	
	@ModelAttribute("categories")
	public List<Category> categories(){
		return adminCategoryService.list();
	}
	
	@RequestMapping("toAdd")
	public String toAdd(Model model) {
		return "admin/secondcategory/add";
	}
	
	@RequestMapping("add")
	public String add(String name,String cid) {
		Secondcategory secondcategory = new Secondcategory();
		secondcategory.setCid(Integer.parseInt(cid));
		secondcategory.setName(name);
		adminSecondCategoryService.add(secondcategory);
		return "redirect:/adminSecondCategory/list";
	}
	
	@RequestMapping("getById")
	public String getById(String id,Model model) {
		Secondcategory secondcategory = adminSecondCategoryService.getById(Integer.parseInt(id));
		List<Category> categories = adminCategoryService.list();
		model.addAttribute("categories",categories);
		model.addAttribute("secondCategory",secondcategory);
		return "admin/secondcategory/edit";
	}
	
	@RequestMapping("/validName")
	@ResponseBody
	public boolean validName(String oldName,String name) {
		return (oldName!=null && name!=null && oldName.equals(name)) || adminSecondCategoryService.getByName(name)==null;
	}
	
	@RequestMapping("update")
	public String update(String cid,String name, String id) {
		Secondcategory secondcategory = new Secondcategory();
		secondcategory.setId(Integer.parseInt(id));
		secondcategory.setCid(Integer.parseInt(cid));
		secondcategory.setName(name);
		adminSecondCategoryService.update(secondcategory);
		return "redirect:/adminSecondCategory/list";
	}
	
}
