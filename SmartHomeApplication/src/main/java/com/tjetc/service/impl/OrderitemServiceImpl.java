package com.tjetc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjetc.domain.Orderitem;
import com.tjetc.mapper.OrderitemMapper;
import com.tjetc.service.OrderitemService;
@Service
public class OrderitemServiceImpl implements OrderitemService {

	@Autowired
	private OrderitemMapper orderitemMapper;
	
	@Override
	public void add(Orderitem orderitem) {
		orderitemMapper.insert(orderitem);
	}

}
