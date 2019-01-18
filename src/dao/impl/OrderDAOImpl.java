/** @file OrderDAOImpl.java
 *  @brief OrderDAOImpl dao implementation
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
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.OrderDAO;
import model.Order;
import model.User;

/**
 * @brief Class OrderDAOImpl
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

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
	public Order getOrderDetailsById(int id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Order.class);
		detachedCriteria.add(Restrictions.eq("idOrder", id));
		List<Order> findByCriteria = (List<Order>) hibernateTemplate.findByCriteria(detachedCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}

	@Override
	public boolean addOrder(Order order) {
		int id = (Integer) hibernateTemplate.save(order);

		if (id > 0)
			return true;
		return false;

	}

	@Override
	public int getLastOrderId() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Order.class);
		List<Order> findByCriteria = (List<Order>) hibernateTemplate.findByCriteria(detachedCriteria);
		return findByCriteria.get(findByCriteria.size()-1).getIdOrder();
		

	}

}
