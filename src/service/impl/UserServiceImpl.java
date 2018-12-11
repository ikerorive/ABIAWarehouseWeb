package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import model.User;
import service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Override
	public boolean registerUser(User user) {
		boolean isRegister=false;
		boolean saveUser = getUserDAO().saveUser(user);
		if(saveUser)
			isRegister=true;
		return isRegister;
	}

	@Override
	public User validateUserCredential(String username, String password) {
		User user = getUserDAO().getUserDetailsByUsernameAndPassword(username, password);
		return user;
	}
}
