package com.tjetc.service;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Admin;

public interface AdminService {

	Admin getByUsername(String username);

	PageInfo<Admin> list(String name, int currentPage, int pageSize);

	void del(int id);

	void add(Admin admin);

	Admin getById(int id);

	void update(Admin admin);

}
