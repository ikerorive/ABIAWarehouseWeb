/** @file PositionService.java
 *  @brief PositionService service
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */





/** @brief package service
 */package service;

/** @brief Libraries
 */

import model.Position;
import java.util.ArrayList;
/**
 * @brief Class PositionService
 */
public interface PositionService {
	/**
	 * @brief Method that returns the position with the given id 	
	 * @param id idPosition
	 * @return Position
	 */
	public abstract Position validatePosition(int id);
	public abstract ArrayList<Position> getPositionByPositionId(int pos);
}
