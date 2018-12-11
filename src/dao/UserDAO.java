package dao;

import model.User;

public interface UserDAO {
	public abstract boolean saveUser(User user);
	public User getUserDetailsByUsernameAndPassword(String username,String password);
}
