package com.tjetc.service;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.User;

public interface UserService {

	PageInfo<User> list(String name, int currentPage, int pageSize);

	void del(int id);

	User getById(int id);

	void update(User user);

	User getByUsername(String username);

	void add(User user);

	void active(String code);

}
