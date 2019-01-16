/** @file User.java
 *  @brief User
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package model
 */
package model;

/** @brief Libraries
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class User
 */
@Entity
@Table(name = "user")
public class User {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idUser")
	private int idUser;

	@NotNull
	@Column(name = "idRole")
	private int idRole;

	@NotEmpty
	@Column(name = "username")
	private String username;

	@NotEmpty
	@Column(name = "password")
	private String password;
	/**
	 * @brief Method for get the value of the idUser variable
	 * @return int
	 */
	public int getIdUser() {
		System.out.println("GetIdUser "+idUser);
		return idUser;
	}
	/**
	 * @brief Method for determine the id of the User
	 * @param idUser id of the user
	 */
	public void setIdUser(int idUser) {
		System.out.println("SetIdUser "+idUser);
		this.idUser = idUser;
	}
	/**
	 * @brief Method for get the value of the idRole variable
	 * @return int
	 */
	public int getIdRole() {
		System.out.println("idrole "+idRole);
		return idRole;
	}
	/**
	 * @brief Method for determine the id of the role
	 * @param idRole id of the role
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	/**
	 * @brief Method for get the value of the username variable
	 * @return String
	 */
	public String getUsername() {
		System.out.println("getusername "+username);
		return username;
	}
	/**
	 * @brief Method for determine the username
	 * @param username username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @brief Method for get the value of the password variable
	 * @return String
	 */
	public String getPassword() {
		System.out.println("password "+password);
		return password;
	}
	/**
	 * @brief Method for determine the password
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
