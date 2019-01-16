/** @file UserCredential.java
 *  @brief User credentials
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package model
 */package model;
 
 /** @brief Libraries
  */
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class UserCredential
 */
public class UserCredential {

	/**
	 * @brief Attributes
	 */
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	/**
	 * @brief Method for get the value of the username variable
	 * @return String
	 */
	public String getUsername() {
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
