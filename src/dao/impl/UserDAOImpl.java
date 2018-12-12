/** @file UserDAOImpl.java
 *  @brief User DAO implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package dao.impl
 */package dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.UserDAO;
import model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Override
	public boolean saveUser(User user) {
		int id = (Integer)hibernateTemplate.save(user);
		if(id>0)
			return true;
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public User getUserDetailsByUsernameAndPassword(String username,String password){
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("username", username));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<User> findByCriteria = (List<User>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;
	}
}
