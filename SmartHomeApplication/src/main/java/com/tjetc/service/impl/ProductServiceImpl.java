package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Product;
import com.tjetc.domain.ProductExample;
import com.tjetc.domain.ProductExample.Criteria;
import com.tjetc.mapper.ProductMapper;
import com.tjetc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public PageInfo<Product> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Product> list = productMapper.selectByExample(example);
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		if (currentPage==pageInfo.getPages()) {
			pageInfo.setNextPage(currentPage);
		}
		if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		return pageInfo;
	}

	@Override
	public Product getByName(String name) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike(name);
		List<Product> list = productMapper.selectByExample(example);
		return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public void add(Product product) {
		productMapper.insert(product);
	}

	@Override
	public void update(Product product) {
		productMapper.updateByPrimaryKey(product);
	}

	@Override
	public Product getById(int id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public void del(int id) {
		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Product> hotList() {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsHotEqualTo(1);
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Product> newsList() {
		ProductExample example = new ProductExample();
		example.setOrderByClause("time desc");
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}

	@Override
	public PageInfo<Product> list(Integer cid, Integer scid, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		List<Product> list = null;
		if (cid!=null) {
			list = productMapper.listByCid(cid);
		}else if (scid!=null) {
			ProductExample example = new ProductExample();
			Criteria criteria = example.createCriteria();
			criteria.andScidEqualTo(scid);
			list = productMapper.selectByExample(example);
		}
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		if (currentPage==pageInfo.getPages()) {
			pageInfo.setNextPage(currentPage);
		}
		if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		return pageInfo;
	}
	
}
