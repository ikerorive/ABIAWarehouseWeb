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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "posType")
public class PosType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idPosType")
	private int idPosType;

	@NotEmpty
	@Column(name = "name")
	private String name;

	public int getIdPosType() {
		return idPosType;
	}

	public void setIdPosType(int idPosType) {
		this.idPosType = idPosType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
