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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class OrderStatus
 */
@Entity
@Table(name = "\"order status\"")
public class OrderStatus {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"idORDER STATUS\"")
	private int idOrderStatus;

	@NotEmpty
	@Column(name = "statusname")
	private String statusName;

	@NotEmpty
	@Column(name = "statusdesc")
	private String statusDesc;

	/**
	 * @brief Method for get the value of the idOrderStatus variable
	 * @return int
	 */
	public int getIdOrderStatus() {
		return idOrderStatus;
	}
	/**
	 * @brief Method for determine the id of the OrderStatus
	 * @param idOrderStatus if of the orderStatus
	 */
	public void setIdOrderStatus(int idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}
	/**
	 * @brief Method for get the value of the statusName variable
	 * @return String
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @brief Method for determine the name of the OrderStatus 
	 * @param statusName name of the OrderStatus
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
	 * @brief Method for determine the description of the OrderStatus 
	 * @param statusDesc description of the orderStatus
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	

}
