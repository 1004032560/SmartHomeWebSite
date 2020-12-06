package com.tjetc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController {

	@Autowired
	public UserService userService;
	
	@RequestMapping("/list")
	public String list(String name,String curPage,Model model) {
		name = name==null?"":name;
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<User> pageInfo = userService.list(name,currentPage,pageSize);
		model.addAttribute("page",pageInfo);
		return "admin/user/list";
	}
	
	@RequestMapping("/del")
	public String del(String id) {
		userService.del(Integer.parseInt(id));
		return "redirect:/adminUser/list";
	}
	
	@RequestMapping("/getById/{id}")
	public String getById(@PathVariable("id") String id, Model model) {
		User user = userService.getById(Integer.parseInt(id));
		model.addAttribute("user",user);
		return "admin/user/edit";
	}
	
	@RequestMapping("/update")
	public String update(Integer id,String username,String password,String name,String email,String phone,String addr,Integer state,String code) {
		User user = new User(id, username, password, name, email, phone, addr, state, code);
		userService.update(user);
		return "redirect:/adminUser/list";
	}
	
}
