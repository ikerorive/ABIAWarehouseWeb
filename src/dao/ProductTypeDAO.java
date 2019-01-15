/** @file ProductTypeDAO.java
 *  @brief ProductTypeDAO dao
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
import java.util.HashMap;
import java.util.List;

import model.ProductType;

/**
 * @brief Interface ProductTypeDAO
 */
public interface ProductTypeDAO {

	/**
	 * @brief Method for getting the ProductType with the id
	 * @param idProductType
	 * @return ProductType
	 */
	public ProductType getNameById(int id);
	/**
	 * @brief Method for getting a Map of the idProductType and the productType
	 * @return HadhMap<Integer, ProductType> 
	 */
	public HashMap<Integer, ProductType> getProductTypeMap();

}
