/** @file VehicleStatusDAO.java
 *  @brief VehicleStatusDAO dao
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
import model.VehicleStatus;

/**
 * @brief Interface VehicleStatusDAO
 */
public interface VehicleStatusDAO {
	/**
	 * @brief Method for getting the vehicleStatus with the id 	
	 * @param id idVehicleStatus
	 * @return VehicleStatus
	 */
	public VehicleStatus getVehicleStatusNameById(int id);
}
