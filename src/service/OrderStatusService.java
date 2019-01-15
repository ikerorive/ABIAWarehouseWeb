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
import model.OrderStatus;

/**
 * @brief Class OrderStatusService
 */
public interface OrderStatusService {
	/**
	 * @brief Method that returns the orderStatus with the given id 
	 * @param id idOrderStatus	
	 * @return OrderStatus
	 */
	public abstract OrderStatus validateOrderStatus(int id);
}
