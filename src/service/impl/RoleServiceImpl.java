/** @file RoleServiceImpl.java
 *  @brief RoleService implementation
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package service.impl
 */package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoleDAO;
import model.Role;
import service.RoleService;


@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
	
	

	@Override
	public Role validateRole(int id) {
		Role role = getRoleDAO().getRoleDetailsById(id);
		return role;
	}
}
