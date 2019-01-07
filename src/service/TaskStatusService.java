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

import model.Task;
import model.TaskStatus;

public interface TaskStatusService {
	public abstract TaskStatus validateTaskStatus(int id);
}