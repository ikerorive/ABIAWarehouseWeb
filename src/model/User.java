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

@Entity
@Table(name = "user")
public class User {

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

	public int getIdUser() {
		System.out.println("GetIdUser "+idUser);
		return idUser;
	}

	public void setIdUser(int idUser) {
		System.out.println("SetIdUser "+idUser);
		this.idUser = idUser;
	}

	public int getIdRole() {
		System.out.println("idrole "+idRole);
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getUsername() {
		System.out.println("getusername "+username);
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		System.out.println("password "+password);
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
