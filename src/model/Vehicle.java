/** @file Vehicle.java
 *  @brief Vehicle
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package model
 */package model;
 
 /** @brief Libraries
  */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @brief Class Vehicle
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idVehicle")
	private int idVehicle;

	@NotNull
	@Column(name = "idPosition")
	private int idPosition;
	
	@NotNull
	@Column(name = "idVehicleStatus")
	private int idVehicleStatus;
	/**
	 * @brief Method for get the value of the idVehicle variable
	 * @return int
	 */
	public int getIdVehicle() {
		return idVehicle;
	}
	/**
	 * @brief Method for determine the id of the vehicle
	 * @param idVehicle id of the vehicle
	 */
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
	/**
	 * @brief Method for get the value of the idPositionvariable
	 * @return int
	 */
	public int getIdPosition() {
		return idPosition;
	}
	/**
	 * @brief Method for determine the id of the position
	 * @param idPosition id of the position
	 */
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
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
	
	
}
