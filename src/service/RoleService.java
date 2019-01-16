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
import model.Role;
import model.User;

/**
 * @brief Class RoleService
 */
public interface RoleService {
	/**
	 * @brief Method that returns the role with the given id 
	 * @param id idRole	
	 * @return Role
	 */
	public abstract Role validateRole(int id);

}