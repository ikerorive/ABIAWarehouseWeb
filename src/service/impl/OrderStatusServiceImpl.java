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
import dao.OrderStatusDAO;
import model.Order;
import model.OrderStatus;
import service.OrderService;
import service.OrderStatusService;


@Service("orderStatusService")
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusDAO orderStatusDAO;



	public OrderStatusDAO getOrderStatusDAO() {
		return orderStatusDAO;
	}



	public void setOrderStatusDAO(OrderStatusDAO orderStatusDAO) {
		this.orderStatusDAO = orderStatusDAO;
	}



	@Override
	public OrderStatus validateOrderStatus(int id) {
		OrderStatus order = getOrderStatusDAO().getOrderStatusDetailsById(id);
		return order;
	}


}
