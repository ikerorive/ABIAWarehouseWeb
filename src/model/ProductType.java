/** @file ProductType.java
 *  @brief ProductType
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package model
 */package model;
 
 /** @brief Libraries
  */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @brief Class ProductType
 */
@Entity
@Table(name = "productType")
public class ProductType {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProductType")
	private int idProductType;

	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotEmpty
	@Column(name = "description")
	private String description;
	/**
	 * @brief Method for get the value of the idProductType variable
	 * @return int
	 */
	public int getIdProductType() {
		return idProductType;
	}
	/**
	 * @brief Method for determine the id of the productType
	 * @param idProductType id of the productType
	 */
	public void setIdProductType(int idProductType) {
		this.idProductType = idProductType;
	}
	/**
	 * @brief Method for get the value of the name variable
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * @brief Method for determine the name of the productType
	 * @param name name of the productType
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @brief Method for get the value of the description variable
	 * @return String
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @brief Method for determine the description of the productType
	 * @param description description of the productType
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
