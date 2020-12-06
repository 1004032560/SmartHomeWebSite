package com.tjetc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orders {
    private String id;

    private String name;

    private String phone;

    private String addr;

    private Integer uid;

    private Double total;

    private Date ordertime;

    private Integer state;

    private List<Orderitem> orderitems = new ArrayList<Orderitem>();

    public List<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "Orders [id=" + id + ", name=" + name + ", phone=" + phone + ", addr=" + addr + ", uid=" + uid
				+ ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", orderitems=" + orderitems
				+ "]";
	}
}