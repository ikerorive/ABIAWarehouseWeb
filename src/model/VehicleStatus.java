/** @file VehicleStatus.java
 *  @brief VehicleStatus
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package model
 */
package model;

/** @brief Libraries
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class VehicleStatus
 */
@Entity
@Table(name = "vehicleStatus")
public class VehicleStatus {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVehicleStatus")
	private int idVehicleStatus;
	
	@NotEmpty
	@Column(name = "statusName")
	private String statusName;

	@NotEmpty
	@Column(name = "statusDesc")
	private String statusDesc;
	/**
	 * @brief Method for get the value of the idVehicleStatus variable
	 * @return int
	 */
	public int getIdVehicleStatus() {
		return idVehicleStatus;
	}
	/**
	 * @brief Method for determine the id of the vehicleStatus
	 * @param idVehicleStatus id of the vehicleStatus
	 */
	public void setIdVehicleStatus(int idVehicleStatus) {
		this.idVehicleStatus = idVehicleStatus;
	}
	/**
	 * @brief Method for get the value of the statusName variable
	 * @return String
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @brief Method for determine the name of the status
	 * @param statusName name of the status
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * @brief Method for get the value of the statusDesc variable
	 * @return String
	 */
	public String getStatusDesc() {
		return statusDesc;
	}
	/**
	 * @brief Method for determine the description of the status
	 * @param statusDesc description of the status
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}