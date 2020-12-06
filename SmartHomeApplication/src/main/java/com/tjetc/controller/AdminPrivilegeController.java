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
import com.tjetc.domain.Privilege;
import com.tjetc.domain.Role;
import com.tjetc.service.AdminPrivilegeService;

@Controller
@RequestMapping("/adminPrivilege")
public class AdminPrivilegeController {

	@Autowired
	private AdminPrivilegeService adminPrivilegeService;

	@RequestMapping("/selPrivByRid")
	@ResponseBody
	public Map<String, Object> selPrivByRid(Integer id){
		Map<String, Object> map=new HashMap<String, Object>();
		//查询所有的角色列表
		List<Privilege> allList=adminPrivilegeService.list();
		List<Privilege> selList=adminPrivilegeService.listByRid(id);
		map.put("allList", allList);
		map.put("selList", selList);
		return map;		
	}
	
	@RequestMapping("/saveRole")
	@ResponseBody
	public boolean saveRole(Integer id,String ids){
	boolean b=	adminPrivilegeService.selPrivByRid(id,ids);
		return b;
	}
	
	
	@RequestMapping("/list")
	public String list(String name,String curPage,Model model){
		 name=name==null?"":name;
		 int currentPage=curPage==null?1:Integer.parseInt(curPage);
		 int pageSize=2;
		 PageInfo<Privilege> pageInfo=adminPrivilegeService.list(name,currentPage,pageSize);
		 if(currentPage==pageInfo.getPages()){
			 pageInfo.setNextPage(currentPage);
		 }
		 if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		 model.addAttribute("page", pageInfo);
		 model.addAttribute("name", name);
		 return "admin/privilege/list";	
	}
	
	 @RequestMapping("/validName")
	 @ResponseBody
	 public boolean validName(String name,String hidName) {
	
	  return  (hidName!=null && name!=null && hidName.equals(name)) || adminPrivilegeService.getByName(name)==null;
	 }
	 
	 @RequestMapping("/getById")
		public String getById(Integer id,Model model){
			Privilege privilege=adminPrivilegeService.getById(id);
			model.addAttribute("p", privilege);
			 return "admin/privilege/edit";
		}
		 @RequestMapping("/del")
		 public String del(Integer id) {
			
			adminPrivilegeService.delete(id);
			
		     return "redirect:/adminPrivilege/list";
		 }
		 
		 @RequestMapping("/update")
		 public String update(Privilege privilege) {
			
			adminPrivilegeService.update(privilege);
			
		     return "redirect:/adminPrivilege/list";
		 }
		 
		 @RequestMapping("/add")
		 public String add(Privilege privilege) {
			
			adminPrivilegeService.add(privilege);
			
		     return "redirect:/adminPrivilege/list";
		 }
	 
}
