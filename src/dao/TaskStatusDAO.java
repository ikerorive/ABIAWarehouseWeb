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

import model.Order;
import model.TaskStatus;

public interface TaskStatusDAO {
	public TaskStatus getTaskStatusDetailsById(int id);
}
