package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Role;

public interface AdminRoleService {

	List<Role> list();

	List<Role> getListByAid(Integer id);

	boolean saveRolesByAid(Integer id, String ids);

	PageInfo<Role> list(String name, int currentPage, int pageSize);

	Role getById(Integer id);

	void delete(Integer id);

	Role getByName(String name);

	void update(Role role);

	void add(Role role);

}
