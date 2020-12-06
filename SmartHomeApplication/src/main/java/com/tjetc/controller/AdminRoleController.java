package com.tjetc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Admin;
import com.tjetc.domain.Role;
import com.tjetc.service.AdminRoleService;

@Controller
@RequestMapping("/adminRole")
public class AdminRoleController {

	@Autowired
	private AdminRoleService adminRoleService;
	
	@RequestMapping("/selRoleByAid")
	@ResponseBody
	public Map<String, Object> selRoleByAid(String id){
		Map<String, Object> map=new HashMap<String, Object>();
		//查询所有的角色列表
		List<Role> allList=adminRoleService.list();
		List<Role> selList=adminRoleService.getListByAid(Integer.valueOf(id));
		map.put("allList", allList);
		map.put("selList", selList);
		return map;		
	}
	
	@RequestMapping("/saveRole")
	@ResponseBody
	public boolean saveRole(Integer id,String ids){
	boolean b=	adminRoleService.saveRolesByAid(id,ids);
		return b;
	}
	
	@RequestMapping("/list")
	public String list(String name,String curPage,Model model){
		 name=name==null?"":name;
		 int currentPage=curPage==null?1:Integer.parseInt(curPage);
		 int pageSize=2;
		 PageInfo<Role> pageInfo=adminRoleService.list(name,currentPage,pageSize);
		 if(currentPage==pageInfo.getPages()){
			 pageInfo.setNextPage(currentPage);
		 }
		 if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		 model.addAttribute("page", pageInfo);
		 model.addAttribute("name", name);
		 return "admin/role/list";	
	}
	
	 @RequestMapping("/validName")
	 @ResponseBody
	 public boolean validName(String name,String hidName) {
		  return  (hidName!=null && name!=null && hidName.equals(name)) || adminRoleService.getByName(name)==null;
	 }
	 
	@RequestMapping("/getById")
	public String getById(Integer id,Model model){
		Role role=adminRoleService.getById(id);
		model.addAttribute("role", role);
		 return "admin/role/edit";
	}
	 @RequestMapping("/del")
	 public String del(Integer id) {
		
		adminRoleService.delete(id);
		
	     return "redirect:/adminRole/list";
	 }
	 
	 @RequestMapping("/update")
	 public String update(Role role) {
		
		adminRoleService.update(role);
		
	     return "redirect:/adminRole/list";
	 }
	 
	 @RequestMapping("/add")
	 public String add(Role role) {
		
		adminRoleService.add(role);
		
	     return "redirect:/adminRole/list";
	 }
}
