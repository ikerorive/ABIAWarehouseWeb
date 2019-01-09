/** @file ProductTypeServiceImpl.java
 *  @brief ProductTypeService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package service.impl
 */package service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductTypeDAO;
import model.ProductType;
import service.ProductTypeService;

@Service("productType")
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Autowired
	private ProductTypeDAO productTypeDAO;

	public void setProducTypeDAO(ProductTypeDAO productTypeDAO) {
		this.productTypeDAO = productTypeDAO;
	}

	public ProductTypeDAO getProductTypeDAO() {
		return productTypeDAO;
	}

	@Override
	public ProductType validateProductType(int id) {
		ProductType productType = getProductTypeDAO().getNameById(id);
		return productType;
	}

	@Override
	public HashMap<Integer, ProductType> getProductTypeMap() {
		// TODO Auto-generated method stub
		HashMap<Integer, ProductType> hmap=getProductTypeDAO().getProductTypeMap();
		return hmap;
	}
}
