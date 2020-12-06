package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Privilege;

public interface AdminPrivilegeService {

	List<Privilege> list();

	List<Privilege> listByRid(Integer id);

	boolean selPrivByRid(Integer id, String ids);

	PageInfo<Privilege> list(String name, int currentPage, int pageSize);

	Privilege getByName(String name);

	Privilege getById(Integer id);

	void delete(Integer id);

	void update(Privilege privilege);

	void add(Privilege privilege);

}
