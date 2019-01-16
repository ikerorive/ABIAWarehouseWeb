/** @file VehicleService.java
 *  @brief VehicleService service
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package service
 */package service;

/** @brief Libraries
 */
import model.Vehicle;

/**
 * @brief Class VehicleService
 */
public interface VehicleService {
	/**
	 * @brief Method that returns the vehicle with the given id 	
	 * @param id idVehicle
	 * @return Vehicle
	 */
	public abstract Vehicle validateVehicle(int id);
}
