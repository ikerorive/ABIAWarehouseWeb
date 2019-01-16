/** @file UserServiceImpl.java
 *  @brief UserService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package service.impl
 */package service.impl;

/** @brief Libraries
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;
import service.UserService;

/**
 * @brief Class UserServiceImpl
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Override
	public User validateUserCredential(String username, String password) {
		User user = getUserDAO().getUserDetailsByUsernameAndPassword(username, password);
		
		return user;
	}
	
	
	@Override
	public boolean registerUser(User user) {
		boolean isRegister=false;
		boolean saveStudent = getUserDAO().addUser(user);
		if(saveStudent)
			isRegister=true;
		return isRegister;
	}
}
