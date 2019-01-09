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

import java.util.HashMap;

import model.ProductType;

public interface ProductTypeService {

	public abstract ProductType validateProductType(int id);
	public abstract HashMap<Integer, ProductType> getProductTypeMap();
}
