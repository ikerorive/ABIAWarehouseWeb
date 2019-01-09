/** @file OrderServiceImpl.java
 *  @brief OrderService implementation
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

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TaskDAO;
import model.Order;
import model.Task;
import service.OrderService;
import service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDAO TaskDAO;

	public TaskDAO getTaskDAO() {
		return TaskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		TaskDAO = taskDAO;
	}

	@Override
	public Task validateOrder(int idOrder, int idProduct) {
		Task task = getTaskDAO().getOrderDetailsByIdOrderAndIdProduct(idOrder, idProduct);
		return task;
	}

	public boolean createTask(Task task) {
		System.out.println("getIdOrder " + task.getIdOrder());
		System.out.println("getIdProduct " + task.getIdProduct());
		System.out.println("getIdVehicle " + task.getIdVehicle());
		System.out.println("getIdStatus " + task.getIdStatus());

		boolean taskCreated = false;
		boolean saveTask = getTaskDAO().addTask(task);
		if (saveTask)
			taskCreated = true;
		return taskCreated;

	}
}
