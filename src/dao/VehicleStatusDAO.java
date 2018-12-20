/** @file VehicleStatusDAO.java
 *  @brief VehicleStatusDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package dao
 */package dao;

import model.VehicleStatus;

public interface VehicleStatusDAO {
	public VehicleStatus getVehicleStatusNameById(int id);
}
