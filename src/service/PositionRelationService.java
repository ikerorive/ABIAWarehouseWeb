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

import model.PositionRelation;

public interface PositionRelationService {
	public abstract PositionRelation validatePositionRelation(int id);
}
