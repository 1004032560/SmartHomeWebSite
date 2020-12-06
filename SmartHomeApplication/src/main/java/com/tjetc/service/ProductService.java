package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Product;

public interface ProductService {

	PageInfo<Product> list(String name, int currentPage, int pageSize);

	Product getByName(String name);

	void add(Product product);

	void update(Product product);

	Product getById(int id);

	void del(int id);

	List<Product> hotList();

	List<Product> newsList();

	PageInfo<Product> list(Integer cid, Integer scid, int currentPage, int pageSize);

}
