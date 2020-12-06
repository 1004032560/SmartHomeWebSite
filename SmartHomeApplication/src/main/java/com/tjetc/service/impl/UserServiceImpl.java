package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.User;
import com.tjetc.domain.UserExample;
import com.tjetc.mapper.UserMapper;
import com.tjetc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public PageInfo<User> list(String name, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		UserExample example = new UserExample();
		example.createCriteria().andNameLike("%"+name+"%");
		List<User> list = userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<User>(list);
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
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User getById(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User getByUsername(String username) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		return list!=null && list.size()>0?list.get(0):null;
	}

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	@Override
	public void active(String code) {
		UserExample example = new UserExample();
		example.createCriteria().andCodeEqualTo(code);
		example.createCriteria().andStateEqualTo(1);
		userMapper.updateByExampleSelective(new User(0,""), example );
	}

}
