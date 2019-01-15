/** @file RoleDAO.java
 *  @brief RoleDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 20/12/2018
 */

/** @brief package dao
 */package dao;
 
 /** @brief Libraries
  */
import model.Role;
import model.User;

/**
 * @brief Interface RoleDAO
 */
public interface RoleDAO {
	/**
	 * @brief Method for getting the Role by id
	 * @param id idRole
	 * @return Role
	 */
	public Role getRoleDetailsById(int id);
	
}
