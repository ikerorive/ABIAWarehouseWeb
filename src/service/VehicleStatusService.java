/** @file VehicleStatusService.java
 *  @brief VehicleStatusService service
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package service
 */package service;

import model.VehicleStatus;

public interface VehicleStatusService {
	public abstract VehicleStatus validateVehicleStatus(int id);
}
