/** @file TaskDAO.java
 *  @brief TaskDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package dao
 */package dao;
 
 /** @brief Libraries
  */
import org.hibernate.mapping.List;

import model.Order;
import model.Task;

/**
 * @brief Interface TaskDAO
 */
public interface TaskDAO {
	/**
	 * @brief Method for getting the Task with the idOrder and the idProduct
	 * @param idOrder idOrder
	 * @param idProduct idProduct 
	 * @return Task
	 */
	public Task getOrderDetailsByIdOrderAndIdProduct(int idOrder, int idProduct);

	/**
	 * @brief Method for adding a task
	 * @param task a task
	 * @return boolean
	 */
	public boolean addTask(Task task);
	
}
