/** @file OrderStatusDAO.java
 *  @brief OrderStatusDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package dao
 */package dao;

 /** @brief Libraries
  */
import model.Order;
import model.OrderStatus;

/**
 * @brief Interface OrderStatusDAO
 */
public interface OrderStatusDAO {
	/**
	 * @brief Method for getting the order status having the id
	 * @param id the idOrderStatus 
	 * @return OrderStatus
	 */
	public OrderStatus getOrderStatusDetailsById(int id);
}
