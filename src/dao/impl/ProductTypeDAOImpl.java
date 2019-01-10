package dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import dao.ProductTypeDAO;
import model.Product;
import model.ProductType;

@Repository
public class ProductTypeDAOImpl implements ProductTypeDAO {

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
	public ProductType getNameById(int id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductType.class);
		detachedCriteria.add(Restrictions.eq("idProductType", id));
		List<ProductType> findByCriteria = (List<ProductType>) hibernateTemplate.findByCriteria(detachedCriteria);
		System.out.println("FIND BY CRITERIA  "+ findByCriteria);
		if (findByCriteria != null && findByCriteria.size() > 0)
			return findByCriteria.get(0);
		else
			return null;
	}

	@Override
	public HashMap<Integer, ProductType> getProductTypeMap() {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ProductType.class);
		
		ArrayList<ProductType> findByCriteria = (ArrayList<ProductType>) hibernateTemplate.findByCriteria(detachedCriteria);
		HashMap<Integer, ProductType> productMap = new HashMap<Integer, ProductType>();
		for (ProductType pt : findByCriteria) {
		   productMap.put(pt.getIdProductType(), pt);
		}
		return productMap;
	}

}
