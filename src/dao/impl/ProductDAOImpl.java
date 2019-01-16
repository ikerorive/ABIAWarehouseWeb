/** @file ProductDAOImpl.java
 *  @brief ProductDAOImpl dao implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package dao.impl
 */
package dao.impl;

/** @brief Libraries
 */
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.ProductDAO;
import model.Product;
import model.Product;

/**
 * @brief Class ProductDAOImpl
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

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
	public Product getProductTypeById(int id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		detachedCriteria.add(Restrictions.eq("idProduct", id));
		List<Product> findByCriteria = (List<Product>) hibernateTemplate.findByCriteria(detachedCriteria);
		System.out.println("FIND BY CRITERIA  " + findByCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Product> getAllProducts() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		detachedCriteria.add(Restrictions.between("position", 100,999));
		ArrayList<Product> findByCriteria = (ArrayList<Product>) hibernateTemplate.findByCriteria(detachedCriteria);

		return findByCriteria;
	}

}
