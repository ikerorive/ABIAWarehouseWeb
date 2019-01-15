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
import model.Task;
import model.TaskStatus;

/**
 * @brief Class TaskStatusService
 */
public interface TaskStatusService {
	/**
	 * @brief Method that returns the taskStatus with the given id 
	 * @param id idTaskStatus	
	 * @return TaskStatus
	 */
	public abstract TaskStatus validateTaskStatus(int id);
}
