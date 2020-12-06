package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Secondcategory;
import com.tjetc.domain.SecondcategoryExample;
import com.tjetc.domain.SecondcategoryExample.Criteria;
import com.tjetc.mapper.SecondcategoryMapper;
import com.tjetc.service.AdminSecondCategoryService;

@Service
public class AdminSecondCategoryServiceImpl implements AdminSecondCategoryService {

	@Autowired
	private SecondcategoryMapper secondcategoryMapper;
	
	@Override
	public PageInfo<Secondcategory> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		SecondcategoryExample example = new SecondcategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Secondcategory> list = secondcategoryMapper.selectByExample(example);
		//List<Secondcategory> list = secondcategoryMapper.list(name);
		PageInfo<Secondcategory> pageInfo = new PageInfo<Secondcategory>(list);
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
		secondcategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Secondcategory getById(int id) {
		Secondcategory secondcategory = secondcategoryMapper.selectByPrimaryKey(id);
		return secondcategory;
	}

	@Override
	public void update(Secondcategory secondcategory) {
		secondcategoryMapper.updateByPrimaryKey(secondcategory);
	}

	@Override
	public void add(Secondcategory secondcategory) {
		secondcategoryMapper.insert(secondcategory);
	}

	@Override
	public Secondcategory getByName(String name) {
		SecondcategoryExample example = new SecondcategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(name);
		List<Secondcategory> list = secondcategoryMapper.selectByExample(example);
		return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public List<Secondcategory> list() {
		List<Secondcategory> list = secondcategoryMapper.selectByExample(null);
		return list;
	}

}
