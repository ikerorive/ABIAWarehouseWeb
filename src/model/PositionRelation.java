/** @file PositionRelation.java
 *  @brief PositionRelation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package model
 */
package model;

/** @brief Libraries
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @brief Class PositionRelation
 */
@Entity
@Table(name = "positionRelation")
@IdClass(PositionRelation.class)
public class PositionRelation implements Serializable {

	/**
	 * @brief Attributes
	 */
	@Id
	@Column(name = "idOrigen")
	private int idOrigen;

	@Id
	@Column(name = "idDestino")
	private int idDestino;
	/**
	 * @brief Method for get the value of the idOrigen variable
	 * @return int
	 */
	public int getIdOrigen() {
		return idOrigen;
	}
	/**
	 * @brief Method for determine the idOrigen
	 * @param idOrigen id of the Origen
	 */
	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}
	/**
	 * @brief Method for get the value of the idDestino variable
	 * @return int
	 */
	public int getIdDestino() {
		return idDestino;
	}
	/**
	 * @brief Method for determine the full of the idDestino
	 * @param idDestino id of the Destino
	 */
	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

}
