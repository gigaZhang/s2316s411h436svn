package com.hysd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; // 客户ID（主键）
	private String name; // 客户姓名
	private Set<Order> orders = new HashSet<Order>(); // 客户的所有订单

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}

}
