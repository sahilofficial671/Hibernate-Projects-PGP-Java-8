package com.newtechbookstore.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.newtechbookstore.model.Order;

public interface OrderDao {
	Order validateAddOrderRequest(HttpServletRequest request);
	Boolean add(Order order);
	Order getById(Integer orderId);
	List<Order> getOrders();
}
