package com.tjetc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Admin;
import com.tjetc.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/validUsername")
	@ResponseBody
	public boolean validUsername(String username) {
		Admin admin = adminService.getByUsername(username);
		return admin!=null;
	}
	
	@RequestMapping("/validPassword")
	@ResponseBody
	public boolean validPassword(String username,String password) {
		Admin admin = adminService.getByUsername(username);
		return admin!=null && admin.getPassword().equals(password);
	}

	@RequestMapping("/login")
	public String login(String username,String password,HttpSession session) {
		Admin admin = adminService.getByUsername(username);
		session.setAttribute("admin", admin);
		return "admin/home";
	}
	
	@RequestMapping("/list")
	public String list(String name,String curPage,Model model) {
		name = name==null?"":name;
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<Admin> pageInfo = adminService.list(name,currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		model.addAttribute("name",name);
		return "admin/admin/list";
	}
	
	@RequestMapping("/del")
	public String del(String id) {
		adminService.del(Integer.parseInt(id));
		return "redirect:/admin/list";
	}
	
	@RequestMapping("/validUsername2")
	@ResponseBody
	public boolean validUsername2(String username) {
		Admin admin = adminService.getByUsername(username);
		return admin==null;
	}
	
	@RequestMapping("/add")
	public String add(String username,String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		adminService.add(admin);
		return "redirect:/admin/list";
	}
	
	@RequestMapping("/getById")
	public String getById(String id,Model model) {
		Admin admin = adminService.getById(Integer.parseInt(id));
		model.addAttribute("admin",admin);
		return "admin/admin/edit";
	}
	
	@RequestMapping("/update")
	public String update(String id, String username, String password) {
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		admin.setUsername(username);
		admin.setPassword(password);
		adminService.update(admin);
		return "redirect:/admin/list";
	}
	
}
