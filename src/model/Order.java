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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class Order
 */
@Entity
@Table(name = "\"order\"")
public class Order {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idOrder")
	private int idOrder;

	@NotNull
	@Column(name = "idUser")
	private int idUser;

	@NotNull
	@Column(name = "idOrderStatus")
	private int idOrderStatus;

	@NotEmpty
	@Column(name = "orderDesc")
	private String orderDesc;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
	@NotNull
	@Column(name = "destino")
	private int destino;

	/**
	 * @brief Method for get the value of the idOrder variable
	 * @return int
	 */
	public int getIdOrder() {
		return idOrder;
	}
	/**
	 * @brief Method for determine the id of the Order 
	 * @param idOrder id of the order
	 */
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	/**
	 * @brief Method for get the value of the idUser variable
	 * @return int
	 */
	public int getIdUser() {
		return idUser;
	}
	/**
	 * @brief Method for determine the id of the User 
	 * @param idUser id of the user
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	/**
	 * @brief Method for get the value of the idOrderStatus variable
	 * @return int
	 */
	public int getIdOrderStatus() {
		return idOrderStatus;
	}
	/**
	 * @brief Method for determine the id of the OrderStatus 
	 * @param idOrderStatu id of the status of the order
	 */
	public void setIdOrderStatus(int idOrderStatus) {
		this.idOrderStatus = idOrderStatus;
	}
	/**
	 * @brief Method for get the value of the orderDesc variable
	 * @return String
	 */
	public String getOrderDesc() {
		return orderDesc;
	}
	/**
	 * @brief Method for determine the description of the Order 
	 * @param orderDesc description of the order
	 */
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	/**
	 * @brief Method for get the value of the date variable
	 * @return Date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @brief Method for determine the date of the Order 
	 * @param date date of the order
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @brief Method for get the value of the destino variable
	 * @return int
	 */
	public int getDestino() {
		return destino;
	}
	/**
	 * @brief Method for determine the destino of the Order 
	 * @param destino destino of the order
	 */
	public void setDestino(int destino) {
		this.destino = destino;
	}

}
