/** @file PositionDAO.java
 *  @brief PositionDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package dao
 */package dao;

 /** @brief Libraries
  */

import model.Position;
import java.util.ArrayList;
/**
 * @brief Interface PositionDAO
 */
public interface PositionDAO {
	/**
	 * @brief Method for getting the Position having the id
	 * @param id idPosition
	 * @return Position
	 */
	public Position getPosNameById(int id);
	public ArrayList<Position> getPositionByType(int posId);
}
