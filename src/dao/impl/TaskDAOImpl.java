/** @file TaskDAOImpl.java
 *  @brief TaskDAOImpl dao implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package dao.impl
 */
package dao.impl;

/** @brief Libraries
 */
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.TaskDAO;
import model.Order;
import model.Product;
import model.Task;

/**
 * @brief Class TaskDAOImpl
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

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
	public Task getOrderDetailsByIdOrderAndIdProduct(int idOrder, int idProduct) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Task.class);
		detachedCriteria.add(Restrictions.eq("idOrder", idOrder));
		detachedCriteria.add(Restrictions.eq("idProduct", idProduct));
		List<Task> findByCriteria = (List<Task>) hibernateTemplate.findByCriteria(detachedCriteria);

		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}

	@Override
	public boolean addTask(Task task) {
		Query query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(
				"INSERT INTO `warehouse`.`task` (`idORDER`, `idPRODUCT`, `idVEHICLE`, `idSTATUS`, `FINISHDATE`) VALUES ('"
						+ task.getIdOrder() + "', '" + task.getIdProduct() + "', '" + task.getIdVehicle() + "', '"
						+ task.getIdStatus() + "', '1970-01-01 00:00:00');");
		query.executeUpdate();
		return true;
	}
}
