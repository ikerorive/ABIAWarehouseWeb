/** @file PosTypeService.java
 *  @brief PosTypeService service
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
import model.PosType;

/**
 * @brief Class PosTypeService
 */
public interface PosTypeService {
	/**
	 * @brief Method that returns the posType with the given id 
	 * @param id idPosType	
	 * @return PosType
	 */
	public abstract PosType validatePosType(int id);
}
