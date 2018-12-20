/** @file PositionRelationServiceImpl.java
 *  @brief PositionRelationService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package service.impl
 */package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PositionRelationDAO;
import model.PositionRelation;
import service.PositionRelationService;

@Service("positionRelation")
public class PositionRelationServiceImpl implements PositionRelationService{
	@Autowired
	private PositionRelationDAO productDAO;

	public void setPositionRelationDAO(PositionRelationDAO productDAO) {
		this.productDAO = productDAO;
	}

	public PositionRelationDAO getPositionRelationDAO() {
		return productDAO;
	}

	@Override
	public PositionRelation validatePositionRelation(int id) {
		PositionRelation product = getPositionRelationDAO().getDestinoByOrigen(id);
		return product;
	}
}
