package com.tjetc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Privilege;
import com.tjetc.domain.PrivilegeExample;
import com.tjetc.domain.RolePrivilegeExample;
import com.tjetc.domain.RolePrivilegeExample.Criteria;
import com.tjetc.domain.RolePrivilegeKey;
import com.tjetc.mapper.PrivilegeMapper;
import com.tjetc.mapper.RolePrivilegeMapper;
import com.tjetc.service.AdminPrivilegeService;
@Service
public class AdminPrivilegeServiceImpl implements AdminPrivilegeService {

	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	@Autowired
	private RolePrivilegeMapper rolePrivilegeMapper;
	@Override
	public List<Privilege> list() {
		
		return privilegeMapper.selectByExample(null);
	}

	@Override
	public List<Privilege> listByRid(Integer id) {
		RolePrivilegeExample example=new RolePrivilegeExample();
		Criteria criteria=example.createCriteria();
		criteria.andRoleIdEqualTo(id);
		rolePrivilegeMapper.selectByExample(example);
		List<RolePrivilegeKey> list=rolePrivilegeMapper.selectByExample(example);
		List<Privilege> privileges=new ArrayList<Privilege>();
		for(RolePrivilegeKey rolePrivilegeMapper:list){
			Privilege privilege=privilegeMapper.selectByPrimaryKey(rolePrivilegeMapper.getPid());
			privileges.add(privilege);
		}
		
		return privileges;
	}

	@Override
	public boolean selPrivByRid(Integer id, String ids) {
		try {
			RolePrivilegeExample example=new RolePrivilegeExample();
			Criteria criteria=example.createCriteria();
			criteria.andRoleIdEqualTo(id);
			rolePrivilegeMapper.deleteByExample(example);
			
			String[] split=ids.split(",");
			for(String rid:split){
				RolePrivilegeKey record=new RolePrivilegeKey();
				record.setRoleId(id);
				record.setPid(Integer.valueOf(rid));
				rolePrivilegeMapper.insert(record);
				
			}
			 return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public PageInfo<Privilege> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		PrivilegeExample example=new PrivilegeExample();
		com.tjetc.domain.PrivilegeExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Privilege> list=privilegeMapper.selectByExample(example);
		PageInfo<Privilege> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Privilege getByName(String name) {
		PrivilegeExample example=new PrivilegeExample();
		com.tjetc.domain.PrivilegeExample.Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		List<Privilege> list=privilegeMapper.selectByExample(example);
		return list!=null  &&  list.size()>0?list.get(0):null;
	}

	@Override
	public Privilege getById(Integer id) {
		// TODO Auto-generated method stub
		return privilegeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delete(Integer id) {
		privilegeMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void update(Privilege privilege) {
		privilegeMapper.updateByPrimaryKey(privilege);
		
	}

	@Override
	public void add(Privilege privilege) {
		privilegeMapper.insert(privilege);
		
	}

	
}
