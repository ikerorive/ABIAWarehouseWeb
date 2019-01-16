/** @file VehicleDAO.java
 *  @brief VehicleDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package dao
 */package dao;
 
 /** @brief Libraries
  */
import model.Vehicle;

/**
 * @brief Interface VehicleDAO
 */
public interface VehicleDAO {
	/**
	 * @brief Method for getting a vehicle with the id
	 * @param id idVehicle
	 * @return Vehicle
	 */
	public Vehicle getVehicleDetailsById(int id);
}
