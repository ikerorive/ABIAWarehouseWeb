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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "vehicleStatus")
public class VehicleStatus {

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

	public int getIdVehicleStatus() {
		return idVehicleStatus;
	}

	public void setIdVehicleStatus(int idVehicleStatus) {
		this.idVehicleStatus = idVehicleStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}