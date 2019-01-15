/** @file TaskServiceImpl.java
 *  @brief TaskService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package service.impl
 */
package service.impl;

/** @brief Libraries
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TaskDAO;
import dao.TaskStatusDAO;
import model.Task;
import model.TaskStatus;
import service.TaskService;
import service.TaskStatusService;


/**
 * @brief Class TaskStatusServiceImpl
 */
@Service("taskStatusService")
public class TaskStatusServiceImpl implements TaskStatusService {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private TaskStatusDAO taskStatusDAO;



	public TaskStatusDAO getTaskStatusDAO() {
		return taskStatusDAO;
	}



	public void setTaskStatusDAO(TaskStatusDAO taskStatusDAO) {
		this.taskStatusDAO = taskStatusDAO;
	}



	@Override
	public TaskStatus validateTaskStatus(int id) {
		TaskStatus task = getTaskStatusDAO().getTaskStatusDetailsById(id);
		return task;
	}


}
