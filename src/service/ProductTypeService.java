/** @file ProductTypeService.java
 *  @brief ProductTypeService service
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
import java.util.HashMap;

import model.ProductType;

/**
 * @brief Class ProductTypeService
 */
public interface ProductTypeService {
	/**
	 * @brief Method that returns the productType with the given id 	
	 * @param id idProductType
	 * @return ProductType
	 */
	public abstract ProductType validateProductType(int id);
	/**
	 * @brief Method that returns a HashMap of idProduct and ProductType 	
	 * @return HashMap<Integer, ProductType>
	 */
	public abstract HashMap<Integer, ProductType> getProductTypeMap();
}
