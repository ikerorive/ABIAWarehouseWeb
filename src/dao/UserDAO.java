
/** @file UserDAO.java
 *  @brief UserDAO
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package dao
 */package dao;

import model.User;

public interface UserDAO {
	public User getUserDetailsByUsernameAndPassword(String username,String password);
	
	public boolean addUser(User user);
}
