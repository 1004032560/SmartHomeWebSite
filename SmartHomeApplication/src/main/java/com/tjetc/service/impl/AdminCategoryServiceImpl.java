package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Category;
import com.tjetc.domain.CategoryExample;
import com.tjetc.domain.CategoryExample.Criteria;
import com.tjetc.domain.SecondcategoryExample;
import com.tjetc.mapper.CategoryMapper;
import com.tjetc.mapper.SecondcategoryMapper;
import com.tjetc.service.AdminCategoryService;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private SecondcategoryMapper secondategoryMapper;
	
	@Override
	public PageInfo<Category> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Category> list = categoryMapper.selectByExample(example);
		PageInfo<Category> pageInfo = new PageInfo<Category>(list);
		if (currentPage==pageInfo.getPages()) {
			pageInfo.setNextPage(currentPage);
		}
		if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		return pageInfo;
	}

	@Override
	public void del(int id) {
		categoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add(Category category) {
		categoryMapper.insert(category);
	}

	@Override
	public Category getByName(String name) {
		CategoryExample example = new CategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(name);
		List<Category> list = categoryMapper.selectByExample(example);
		return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public Category getById(int id) {
		Category category = categoryMapper.selectByPrimaryKey(id);
		return category;
	}

	@Override
	public void update(Category category) {
		categoryMapper.updateByPrimaryKey(category);
	}

	@Override
	public List<Category> list() {
		List<Category> list = categoryMapper.selectByExample(null);
		for (Category category : list) {
			SecondcategoryExample example = new SecondcategoryExample();
			example.createCriteria().andCidEqualTo(category.getId());
			category.setSecondCategories(secondategoryMapper.selectByExample(example));
		}
		return list;
	}

}
