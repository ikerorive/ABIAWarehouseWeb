/** @file PosTypeDAO.java
 *  @brief PosTypeDAO dao
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
import model.PosType;

/**
 * @brief Interface PosTypeDAO
 */
public interface PosTypeDAO {

	/**
	 * @brief Method for getting the PosType having the id
	 * @param idPosType
	 * @return PosType
	 */
	public PosType getNameById(int id);
}
