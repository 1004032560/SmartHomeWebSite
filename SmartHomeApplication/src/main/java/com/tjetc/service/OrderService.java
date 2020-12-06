package com.tjetc.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Orderitem;
import com.tjetc.domain.Orders;

public interface OrderService {

	void add(Orders orders);

	void update(Orders orders);

	PageInfo<Orders> list(Integer id,int currentPage,int pageSize);

	void updateState(String id,Integer state);

	PageInfo<Orders> list(String orderId, int currentPage, int pageSize);

	List<Orderitem> list(String id);

}
