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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
 @Table(name = "position")
public class Position {

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

	public int getIdPosition() {
		return idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public int getIdPostype() {
		return idPostype;
	}

	public void setIdPostype(int idPostype) {
		this.idPostype = idPostype;
	}

	public int getFull() {
		return full;
	}

	public void setFull(int full) {
		this.full = full;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
	
	
}
