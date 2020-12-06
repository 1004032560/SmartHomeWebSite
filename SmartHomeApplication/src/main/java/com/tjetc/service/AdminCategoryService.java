package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Category;

public interface AdminCategoryService {

	List<Category> list();

	void del(int id);

	void add(Category category);

	Category getByName(String name);

	Category getById(int id);

	void update(Category category);

	PageInfo<Category> list(String name, int currentPage, int pageSize);

}
