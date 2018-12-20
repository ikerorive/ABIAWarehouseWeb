/** @file ProductTypeDAO.java
 *  @brief ProductTypeDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package dao
 */package dao;

import model.ProductType;

public interface ProductTypeDAO {

	public ProductType getNameById(int id);
	
}
