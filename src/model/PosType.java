/** @file PosType.java
 *  @brief PosType
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
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

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class PosType
 */
@Entity
@Table(name = "posType")
public class PosType {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPosType")
	private int idPosType;

	@NotEmpty
	@Column(name = "name")
	private String name;
	/**
	 * @brief Method for get the value of the idPosType variable
	 * @return int
	 */
	public int getIdPosType() {
		return idPosType;
	}
	/**
	 * @brief Method for determine the id of the PosType
	 * @param idPosType id of the PosType
	 */
	public void setIdPosType(int idPosType) {
		this.idPosType = idPosType;
	}
	/**
	 * @brief Method for get the value of the name variable
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * @brief Method for determine the name of the PosType
	 * @param name name of the posType
	 */
	public void setName(String name) {
		this.name = name;
	}

}
