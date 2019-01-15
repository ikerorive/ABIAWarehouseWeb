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
 * @brief Class TaskStatus
 */
@Entity
@Table(name = "\"taskstatus\"")
public class TaskStatus {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"idTASKSTATUS\"")
	private int idTaskStatus;

	@NotEmpty
	@Column(name = "statusname")
	private String statusName;

	@NotEmpty
	@Column(name = "statusdesc")
	private String statusDesc;
	/**
	 * @brief Method for get the value of the idTaskStatus variable
	 * @return int
	 */
	public int getIdTaskStatus() {
		return idTaskStatus;
	}
	/**
	 * @brief Method for determine the id of the taskStatus
	 * @param idTaskStatus id of the taskStatus
	 */
	public void setIdTaskStatus(int idTaskStatus) {
		this.idTaskStatus = idTaskStatus;
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
