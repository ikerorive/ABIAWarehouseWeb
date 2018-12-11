package service;

import model.User;

public interface UserService {
	public abstract User validateUserCredential(String username,	String password);
	public abstract boolean registerUser(User user);

}