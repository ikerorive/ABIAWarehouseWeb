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

/** @brief Libraries
 */
import model.Order;

/**
 * @brief Class OrderService
 */
public interface OrderService {
	/**
	 * @brief Method that returns an orden with the given id
	 * @param id idOrder
	 * @return Order
	 */
	public abstract Order validateOrder(int id);
	/**
	 * @brief Method that return the last order id  	
	 * @return int
	 */
	public abstract int getLastId();
	/**
	 * @brief Method that creates an order and save it in the database
	 * @param order an Order
	 * @return boolean
	 */
	public abstract boolean createOrder(Order order);
}
