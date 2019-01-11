/** @file OrderServiceImpl.java
 *  @brief OrderService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package service.impl
 */
package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDAO;
import model.Order;

import service.OrderService;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	@Override
	public Order validateOrder(int id) {
		Order order = getOrderDAO().getOrderDetailsById(id);
		return order;
	}

	public boolean createOrder (Order order) {
		boolean orderCreated=false;
		boolean saveOrder = getOrderDAO().addOrder(order);
		if(saveOrder)
			orderCreated=true;
		return orderCreated;
	}

	@Override
	public int getLastId() {
		int order = getOrderDAO().getLastOrderId();
		return order;
	}

}
