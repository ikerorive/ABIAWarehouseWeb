/** @file Role.java
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

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class Role
 */
@Entity
@Table(name = "role")
public class Role {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idRole")
	private int idRole;

	@NotEmpty
	@Column(name = "rolename")
	private String rolename;

	@NotEmpty
	@Column(name = "roledesc")
	private String roledesc;
	/**
	 * @brief Method for get the value of the idRole variable
	 * @return int
	 */
	public int getIdRole() {
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
	 * @brief Method for get the value of the rolename variable
	 * @return String
	 */
	public String getRolename() {
		return rolename;
	}
	/**
	 * @brief Method for determine the name of the role
	 * @param rolename name of the role
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	/**
	 * @brief Method for get the value of the roledesc variable
	 * @return String
	 */
	public String getRoledesc() {
		return roledesc;
	}
	/**
	 * @brief Method for determine the description of the role
	 * @param roledesc description of the role
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

}
