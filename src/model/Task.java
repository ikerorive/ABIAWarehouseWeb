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
 */
package model;

/** @brief Libraries
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class Task
 */
@Entity
@Table(name = "\"task\"")
@IdClass(Task.class)
public class Task implements Serializable {

	/**
	 * @brief Attributes
	 */
	@Id
	@Column(name = "idOrder")
	private int idOrder;

	@Id
	@Column(name = "idProduct")
	private int idProduct;

	@Column(name = "idVehicle")
	private int idVehicle;

	@Column(name = "idStatus")
	private int idStatus;

	@Column(name = "finishdate")
	private Date finishDate;
	/**
	 * @brief Method for get the value of the idOrder variable
	 * @return int
	 */
	public int getIdOrder() {
		return idOrder;
	}
	/**
	 * @brief Method for determine the idOrder of the task
	 * @param idOrder idOrder of the task
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	/**
	 * @brief Method for get the value of the idProduct variable
	 * @return int
	 */
	public int getIdProduct() {
		return idProduct;
	}
	/**
	 * @brief Method for determine the idProduct of the task
	 * @param idProduct idProduct of the task
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
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
	 * @brief Method for get the value of the idStatus variable
	 * @return int
	 */
	public int getIdStatus() {
		return idStatus;
	}
	/**
	 * @brief Method for determine the id of the status
	 * @param idStatus id of the status
	 */
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	/**
	 * @brief Method for get the value of the finishDate variable
	 * @return Date
	 */
	public Date getFinishDate() {
		return finishDate;
	}
	/**
	 * @brief Method for determine the finishDate of the task
	 * @param finishDate finishDate of the task
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

}
