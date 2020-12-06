package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Secondcategory;

public interface AdminSecondCategoryService {

	PageInfo<Secondcategory> list(String name, int currentPage, int pageSize);

	void del(int id);

	Secondcategory getById(int id);

	void update(Secondcategory secondcategory);

	void add(Secondcategory secondcategory);

	Secondcategory getByName(String name);

	List<Secondcategory> list();

}
