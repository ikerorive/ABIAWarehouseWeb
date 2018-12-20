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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "\"taskstatus\"")
public class TaskStatus {

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

	public int getIdTaskStatus() {
		return idTaskStatus;
	}

	public void setIdTaskStatus(int idTaskStatus) {
		this.idTaskStatus = idTaskStatus;
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
