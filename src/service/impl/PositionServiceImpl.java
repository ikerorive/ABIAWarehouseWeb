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

/** @brief Libraries
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import dao.PositionDAO;
import model.Position;
import service.PositionService;

/**
 * @brief Class PositionServiceImpl
 */
@Service("position")
public class PositionServiceImpl implements PositionService {

	/**
	 * @brief Attributes
	 */
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

	@Override
	public ArrayList<Position> getPositionByPositionId(int pos) {
		ArrayList<Position> position = getPositionDAO().getPositionByType(pos);
		return position;
	}
}
