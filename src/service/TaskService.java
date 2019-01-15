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
import model.Task;

/**
 * @brief Class TaskService
 */
public interface TaskService {
	/**
	 * @brief Method that returns the task with the given idOrder and idProduct 	
	 * @param idOrder idOrder
	 * @param idProduct idProduct
	 * @return Task
	 */
	public abstract Task validateOrder(int idOrder, int idProduct);
	/**
	 * @brief Method that creates a task and save it in the database 
	 * @param task a Task	
	 * @return boolean
	 */
	public abstract boolean createTask(Task task);
}
