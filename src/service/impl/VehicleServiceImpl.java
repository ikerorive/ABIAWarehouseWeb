/** @file VehicleServiceImpl.java
 *  @brief VehicleService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package service.impl
 */package service.impl;

/** @brief Libraries
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VehicleDAO;
import model.Vehicle;
import service.VehicleService;

/**
 * @brief Class VehicleServiceImpl
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private VehicleDAO vehicleDAO;

	public void setVehicleDAO(VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}

	public VehicleDAO getVehicleDAO() {
		return vehicleDAO;
	}

	@Override
	public Vehicle validateVehicle(int id) {
		Vehicle vehicle = getVehicleDAO().getVehicleDetailsById(id);
		return vehicle;
	}
}
