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

import model.Role;
import model.User;

public interface RoleService {
	public abstract Role validateRole(int id);

}