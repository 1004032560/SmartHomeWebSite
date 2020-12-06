package com.tjetc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjetc.domain.Orderitem;
import com.tjetc.domain.OrderitemExample;
import com.tjetc.domain.Orders;
import com.tjetc.domain.OrdersExample;
import com.tjetc.mapper.OrderitemMapper;
import com.tjetc.mapper.OrdersMapper;
import com.tjetc.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrderitemMapper orderitemMapper;
	
	@Override
	public void add(Orders orders) {
		ordersMapper.insert(orders);
	}

	@Override
	public void update(Orders orders) {
		ordersMapper.updateByPrimaryKeySelective(orders);
	}

	@Override
	public PageInfo<Orders> list(Integer id,int currentPage,int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		OrdersExample example = new OrdersExample();
		example.createCriteria().andUidEqualTo(id);
		List<Orders> list = ordersMapper.selectByExample(example);
		for (Orders orders : list) {
			OrderitemExample example2 = new OrderitemExample();
			example2.createCriteria().andOrderIdEqualTo(orders.getId());
			List<Orderitem> list2 = orderitemMapper.selectByExample(example2);
			orders.setOrderitems(list2);
		}
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(list);
		if (currentPage==pageInfo.getPages()) {
			pageInfo.setNextPage(currentPage);
		}
		if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		return pageInfo;
	}

	@Override
	public void updateState(String id,Integer state) {
		Orders orders = new Orders();
		orders.setId(id);
		orders.setState(state);
		ordersMapper.updateByPrimaryKeySelective(orders);
	}

	@Override
	public PageInfo<Orders> list(String orderId, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		OrdersExample example = new OrdersExample();
		example.createCriteria().andIdLike("%"+orderId+"%");
		List<Orders> list = ordersMapper.selectByExample(example);
		for (Orders orders : list) {
			OrderitemExample example2 = new OrderitemExample();
			example2.createCriteria().andOrderIdEqualTo(orders.getId());
			List<Orderitem> list2 = orderitemMapper.selectByExample(example2);
			orders.setOrderitems(list2);
		}
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(list);
		if (currentPage==pageInfo.getPages()) {
			pageInfo.setNextPage(currentPage);
		}
		if (currentPage==1) {
			pageInfo.setPrePage(1);
		}
		return pageInfo;
	}

	@Override
	public List<Orderitem> list(String id) {
		OrderitemExample example = new OrderitemExample();
		example.createCriteria().andOrderIdEqualTo(id);
		List<Orderitem> list = orderitemMapper.selectByExample(example);
		return list;
	}

}
