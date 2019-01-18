/** @file StatusDAOImpl.java
 *  @brief StatusDAOImpl dao implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package dao.impl
 */package dao.impl;
 
 /** @brief Libraries
  */
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.TaskStatusDAO;
import model.TaskStatus;

/**
 * @brief Class TaskStatusDAOImpl
 */
@Repository
public class TaskStatusDAOImpl implements TaskStatusDAO {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TaskStatus getTaskStatusDetailsById(int id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(TaskStatus.class);
		detachedCriteria.add(Restrictions.eq("idTaskStatus", id));
		List<TaskStatus> findByCriteria = (List<TaskStatus>) hibernateTemplate.findByCriteria(detachedCriteria);

		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}
	

}
