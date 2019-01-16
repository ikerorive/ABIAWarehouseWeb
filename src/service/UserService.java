/** @file UserService.java
 *  @brief UserService
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package service
 */package service;

/** @brief Libraries
 */
import model.User;

/**
 * @brief Class UserService
 */
public interface UserService {
	/**
	 * @brief Method that returns the user with the given username and password	
	 * @param username username
	 * @param password password
	 * @return User
	 */
	public abstract User validateUserCredential(String username, String password);
	/**
	 * @brief Method that save a new user in the database 	
	 * @param user a User
	 * @return boolean
	 */
	public abstract boolean registerUser(User user);
	
}