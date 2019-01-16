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

import java.util.ArrayList;

import model.Position;
public interface PositionDAO {
	public Position getPosNameById(int id);
	public ArrayList<Position> getPositionByType(int posId);
}
