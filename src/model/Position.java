/** @file Position.java
 *  @brief Position
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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class Position
 */
@Entity
 @Table(name = "position")
public class Position {

	/**
	 * @brief Attributes
	 */
	@Id
	@Column(name = "idPosition")
	private int idPosition;

	@NotNull
	@Column(name = "idPostype")
	private int idPostype;
	
	@NotNull
	@Column(name = "full")
	private int full;
	
	@NotEmpty
	@Column(name = "posName")
	private String posName;
	/**
	 * @brief Method for get the value of the idPosition variable
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
	 * @brief Method for get the value of the idPosType variable
	 * @return int
	 */
	public int getIdPostype() {
		return idPostype;
	}
	/**
	 * @brief Method for determine the id of the PosType 
	 * @param idPostype the id of the posType
	 */
	public void setIdPostype(int idPostype) {
		this.idPostype = idPostype;
	}
	/**
	 * @brief Method for get the value of the full variable
	 * @return int
	 */
	public int getFull() {
		return full;
	}
	/**
	 * @brief Method for determine the full of the position
	 * @param full full of the position
	 */
	public void setFull(int full) {
		this.full = full;
	}
	/**
	 * @brief Method for get the value of the posName variable
	 * @return String
	 */
	public String getPosName() {
		return posName;
	}
	/**
	 * @brief Method for determine the name of the Position 
	 * @param posName name of the position
	 */
	public void setPosName(String posName) {
		this.posName = posName;
	}
	
	
}
