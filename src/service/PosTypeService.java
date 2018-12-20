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

import model.PosType;

public interface PosTypeService {

	public abstract PosType validatePosType(int id);
}
