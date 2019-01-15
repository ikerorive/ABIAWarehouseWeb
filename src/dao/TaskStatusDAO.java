/** @file TaskStatusDAO.java
 *  @brief TaskStatusDAO dao
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
import model.TaskStatus;

/**
 * @brief Interface TaskStatusDAO
 */
public interface TaskStatusDAO {
	/**
	 * @brief Method for getting the taskStatus with the id
	 * @param id idTaskStatus
	 * @return TaskStatus
	 */
	public TaskStatus getTaskStatusDetailsById(int id);
}
