/** @file ProductService.java
 *  @brief ProductService service
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package service
 */package service;

/** @brief Libraries
 */
import java.util.ArrayList;

import model.Product;

/**
 * @brief Class ProductService
 */
public interface ProductService {
	/**
	 * @brief Method that returns the product with the given id 	
	 * @param id idProduct
	 * @return Product
	 */
	public abstract Product validateProduct(int id);
	/**
	 * @brief Method that returns an array with all the products
	 * @return ArrayList<Product>
	 */
	public abstract ArrayList<Product> getProducts();
}
