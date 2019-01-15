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
 
 /** @brief Libraries
  */
import model.PositionRelation;

/**
 * @brief Interface PositionRelationDAO
 */
public interface PositionRelationDAO {
	/**
	 * @brief Method for getting all the PositionRelations with the specified Origen
	 * @param id idOrigen
	 * @return PositionRelation	
	 */
	public PositionRelation getDestinoByOrigen(int id);
}
