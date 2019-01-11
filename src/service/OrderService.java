/** @file VehicleService.java
 *  @brief VehicleService service
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package service
 */package service;

import model.Order;

public interface OrderService {
	public abstract Order validateOrder(int id);
	public abstract int getLastId();
	public abstract boolean createOrder(Order order);
}
