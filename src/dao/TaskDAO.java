/** @file OrderDAO.java
 *  @brief OrderDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package dao
 */package dao;

import org.hibernate.mapping.List;

import model.Order;
import model.Task;

public interface TaskDAO {
	public Task getOrderDetailsByIdOrderAndIdProduct(int idOrder, int idProduct);

	public boolean addTask(Task task);
	
}
