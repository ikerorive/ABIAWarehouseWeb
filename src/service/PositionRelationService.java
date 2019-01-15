/** @file PositionRelationService.java
 *  @brief PositionRelationService service
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
import model.PositionRelation;

/**
 * @brief Class PositionRelationService
 */
public interface PositionRelationService {
	/**
	 * @brief Method that returns the positionRelation with the given id 	
	 * @param id idPositionRelation
	 * @return PositionRelation
	 */
	public abstract PositionRelation validatePositionRelation(int id);
}
