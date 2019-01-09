/** @file ProductDAO.java
 *  @brief ProductDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package dao
 */package dao;

import java.util.ArrayList;

import model.Product;

public interface ProductDAO {
	public Product getProductTypeById(int id);
	
	public ArrayList<Product> getAllProducts();
}
