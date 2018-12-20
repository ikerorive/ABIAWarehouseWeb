/** @file PositionRelationDAO.java
 *  @brief PositionRelationDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package dao
 */package dao;

import model.PositionRelation;

public interface PositionRelationDAO {
	public PositionRelation getDestinoByOrigen(int id);
}
