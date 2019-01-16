/** @file ProductDAO.java
 *  @brief ProductDAO dao
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
import java.util.ArrayList;

import model.Product;

/**
 * @brief Interface ProductDAO
 */
public interface ProductDAO {
	/**
	 * @brief Method for getting the Product with the specified id
	 * @param idProduct
	 * @return Product
	 */
	public Product getProductTypeById(int id);
	
	/**
	 * @brief Method for getting all the products
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getAllProducts();
}
