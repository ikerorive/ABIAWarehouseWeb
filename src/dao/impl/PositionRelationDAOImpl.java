/** @file PositionRelationDAOImpl.java
 *  @brief PositionRelationDAOImpl dao implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
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

import dao.PositionRelationDAO;
import model.PositionRelation;

/**
 * @brief Class PositionRelationDAOImpl
 */
@Repository
public class PositionRelationDAOImpl implements PositionRelationDAO{

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
	public PositionRelation getDestinoByOrigen(int id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PositionRelation.class);
		detachedCriteria.add(Restrictions.eq("idOrigen", id));
		List<PositionRelation> findByCriteria = (List<PositionRelation>) hibernateTemplate.findByCriteria(detachedCriteria);
		System.out.println("FIND BY CRITERIA  "+ findByCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}
	
}
