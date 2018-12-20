/** @file PosTypeDAO.java
 *  @brief PosTypeDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package dao
 */package dao;

import model.PosType;

public interface PosTypeDAO {

	public PosType getNameById(int id);
}
