/** @file PositionServiceImpl.java
 *  @brief PositionService implementation
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

import dao.PositionDAO;
import model.Position;
import service.PositionService;

@Service("position")
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionDAO positionDAO;

	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

	public PositionDAO getPositionDAO() {
		return positionDAO;
	}

	@Override
	public Position validatePosition(int id) {
		Position position = getPositionDAO().getPosNameById(id);
		return position;
	}
}
