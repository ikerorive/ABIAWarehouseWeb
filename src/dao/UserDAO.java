/** @file UserDAO.java
 *  @brief UserDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package dao
 */package dao;

 /** @brief Libraries
  */
import model.User;

/**
 * @brief Interface UserDAO
 */
public interface UserDAO {
	/**
	 * @brief Method for getting the user details with the username and password
	 * @param username username
	 * @param password password
	 * @return User
	 */
	public User getUserDetailsByUsernameAndPassword(String username,String password);
	
	/**
	 * @brief Method for adding a user
	 * @param user a User
	 * @return boolean
	 */
	public boolean addUser(User user);
}
