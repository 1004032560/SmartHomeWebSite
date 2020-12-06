package com.tjetc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.AdminRoleExample;
import com.tjetc.domain.AdminRoleExample.Criteria;
import com.tjetc.domain.AdminRoleKey;
import com.tjetc.domain.Role;
import com.tjetc.domain.RoleExample;
import com.tjetc.mapper.AdminRoleMapper;
import com.tjetc.mapper.RoleMapper;
import com.tjetc.service.AdminRoleService;
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private AdminRoleMapper adminRoleMapper;
	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return 	roleMapper.selectByExample(null);
		
	}
	@Override
	  public List<Role> getListByAid(Integer id) {
	    AdminRoleExample example=new AdminRoleExample();
	    Criteria criteria = example.createCriteria();
	    criteria.andAdminIdEqualTo(id);
	    List<AdminRoleKey> list = adminRoleMapper.selectByExample(example);
	    List<Role> roles=new ArrayList<Role>();
	    for (AdminRoleKey adminRoleKey : list) {
	      Role role = roleMapper.selectByPrimaryKey(adminRoleKey.getRoleId());
	      roles.add(role);
	    }
	    return roles;
	  }
	@Override
	public boolean saveRolesByAid(Integer id, String ids) {
		 try {
		      //删除admin_role的admin_id=id的记录,解除关系
		      AdminRoleExample example=new AdminRoleExample();
		      Criteria criteria = example.createCriteria();
		      criteria.andAdminIdEqualTo(id);
		      adminRoleMapper.deleteByExample(example);
		      //admin_role添加记录,建立关系
		      String[] split = ids.split(",");
		      for (String rid : split) {
		        AdminRoleKey record=new AdminRoleKey();
		        record.setAdminId(id);
		        record.setRoleId(Integer.valueOf(rid));
		        adminRoleMapper.insert(record);
		      }
		      return true;
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		      return false;
		    }
		
	}
	@Override
	public PageInfo<Role> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		RoleExample example=new RoleExample();
		com.tjetc.domain.RoleExample.Criteria criteria=example.createCriteria();
		criteria.andNameLike("%"+name+"%");
		List<Role> list=roleMapper.selectByExample(example);
		PageInfo<Role> pageInfo=new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public Role getById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(Integer id) {
		roleMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public Role getByName(String name) {
		RoleExample example=new RoleExample();
		com.tjetc.domain.RoleExample.Criteria criteria=example.createCriteria();
		criteria.andNameEqualTo(name);
		List<Role> list=roleMapper.selectByExample(example);
		return list!=null  &&  list.size()>0?list.get(0):null;
	}
	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKey(role);
		
	}
	@Override
	public void add(Role role) {
		roleMapper.insert(role);
		
	}

}
