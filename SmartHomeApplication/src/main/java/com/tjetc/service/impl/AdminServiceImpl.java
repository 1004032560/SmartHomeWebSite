package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Admin;
import com.tjetc.domain.AdminExample;
import com.tjetc.domain.AdminExample.Criteria;
import com.tjetc.mapper.AdminMapper;
import com.tjetc.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin getByUsername(String username) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<Admin> list = adminMapper.selectByExample(example);
		return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public PageInfo<Admin> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameLike("%"+name+"%");
		List<Admin> list = adminMapper.selectByExample(example);
		PageInfo<Admin> pageInfo = new PageInfo<Admin>(list);
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
		adminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void add(Admin admin) {
		adminMapper.insert(admin);
	}

	@Override
	public Admin getById(int id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		return admin;
	}

	@Override
	public void update(Admin admin) {
		adminMapper.updateByPrimaryKey(admin);
	}

}
