package com.tjetc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Product;
import com.tjetc.domain.Secondcategory;
import com.tjetc.service.AdminSecondCategoryService;
import com.tjetc.service.ProductService;

@Controller
@RequestMapping("/adminProduct")
public class AdminProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private AdminSecondCategoryService adminSecondCategoryService;
	
	@RequestMapping("/list")
	public String list(String name, String curPage, Model model) {
		name = name==null?"":name;
		int currentPage = curPage==null?1:Integer.parseInt(curPage);
		int pageSize = 5;
		PageInfo<Product> pageInfo = productService.list(name,currentPage,pageSize);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("name",name);
		return "admin/product/list";
	}
	
	@RequestMapping("/validName")
	@ResponseBody
	public boolean validName(String oldName,String name) {
		return (oldName!=null && name!=null && oldName.equals(name)) || productService.getByName(name)==null;
	}

	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<Secondcategory> list = adminSecondCategoryService.list();
		model.addAttribute("seconds",list);
		return "admin/product/add";
	}
	
	@RequestMapping("/add")
	public String add(String name,String isHot,String marketPrice,String shopPrice,String scid,String description,MultipartFile photo, HttpServletRequest request) {
		String photoPath = null;
		if (photo != null && photo.getSize() > 0) {
			String realPath = request.getServletContext().getRealPath("/upload/");
			File dir = new File(realPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File destFile = new File(dir, photo.getOriginalFilename());
			try {
				photo.transferTo(destFile);
				System.out.println("上传成功");
				photoPath = "upload/" + photo.getOriginalFilename();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Product product = new Product(name,Integer.parseInt(isHot),Integer.parseInt(scid),Long.valueOf(marketPrice),Long.valueOf(shopPrice),description,photoPath, new Date());
		productService.add(product);
		return "redirect:/adminProduct/list";
	}
	
	@RequestMapping("/getById/{id}")
	public String getById(@PathVariable("id") String id, Model model) {
		Product product = productService.getById(Integer.parseInt(id));
		model.addAttribute("product",product);
		List<Secondcategory> list = adminSecondCategoryService.list();
		model.addAttribute("seconds",list);
		return "admin/product/edit";
	}
	
	@RequestMapping("/update")
	public String update(String id,String image,String name,String isHot,String marketPrice,String shopPrice,String scid,String description,MultipartFile photo, HttpServletRequest request) {
		String photoPath = null;
		if (photo != null && photo.getSize() > 0) {
			String realPath = request.getServletContext().getRealPath("/upload/");
			File dir = new File(realPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File destFile = new File(dir, photo.getOriginalFilename());
			try {
				photo.transferTo(destFile);
				System.out.println("上传成功");
				photoPath = "upload/" + photo.getOriginalFilename();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			photoPath = image;
		}
		Product product = new Product(Integer.parseInt(id),name,Integer.parseInt(isHot),Integer.parseInt(scid),Long.valueOf(marketPrice),Long.valueOf(shopPrice),description,photoPath, new Date());
		productService.update(product);
		return "redirect:/adminProduct/list";
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable("id") String id) {
		productService.del(Integer.parseInt(id));
		return "redirect:/adminProduct/list";
	}
	
}
