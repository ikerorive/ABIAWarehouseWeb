/** @file PosTypeServiceImpl.java
 *  @brief PosTypeService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package service.impl
 */package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PosTypeDAO;
import model.PosType;
import service.PosTypeService;

@Service("posType")
public class PosTypeServiceImpl implements PosTypeService{

	@Autowired
	private PosTypeDAO posTypeDAO;

	public void setPosTypeDAO(PosTypeDAO posTypeDAO) {
		this.posTypeDAO = posTypeDAO;
	}

	public PosTypeDAO getPosTypeDAO() {
		return posTypeDAO;
	}

	@Override
	public PosType validatePosType(int id) {
		PosType posType = getPosTypeDAO().getNameById(id);
		return posType;
	}
}
