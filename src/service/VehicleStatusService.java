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

/** @brief Libraries
 */
import model.VehicleStatus;

/**
 * @brief Class VehicleStatusService
 */
public interface VehicleStatusService {
	/**
	 * @brief Method that returns the vehicleStatus with the given id 	
	 * @param id idVehicleStatus
	 * @return VehicleStatus
	 */
	public abstract VehicleStatus validateVehicleStatus(int id);
}
