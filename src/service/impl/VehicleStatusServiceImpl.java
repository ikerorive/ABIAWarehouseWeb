/** @file VehicleStatusServiceImpl.java
 *  @brief VehicleStatusService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package service.impl
 */package service.impl;

/** @brief Libraries
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VehicleStatusDAO;
import model.VehicleStatus;
import service.VehicleStatusService;

/**
 * @brief Class VehicleStatusServiceImpl
 */
@Service("vehicleStatusService")
public class VehicleStatusServiceImpl implements VehicleStatusService {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private VehicleStatusDAO vehicleStatusDAO;

	public void setVehicleStatusDAO(VehicleStatusDAO vehicleStatusDAO) {
		this.vehicleStatusDAO = vehicleStatusDAO;
	}

	public VehicleStatusDAO getVehicleStatusDAO() {
		return vehicleStatusDAO;
	}

	@Override
	public VehicleStatus validateVehicleStatus(int id) {
		VehicleStatus vehicleStatus = getVehicleStatusDAO().getVehicleStatusNameById(id);
		return vehicleStatus;
	}
}
