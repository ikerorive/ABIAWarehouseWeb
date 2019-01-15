/** @file Product.java
 *  @brief Product
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 19/12/2018
 */

/** @brief package model
 */
package model;

/** @brief Libraries
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * @brief Class Product
 */
@Entity
@Table(name = "product")
public class Product {

	/**
	 * @brief Attributes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProduct")
	private int idProduct;

	@NotNull
	@Column(name = "productType")
	private int productType;

	@NotNull
	@Column(name = "position")
	private int position;

	@Transient
	private String name;

	@Transient
	private String description;

	/**
	 * @brief Method for get the value of the decription variable
	 * @return String
	 */
	@Transient
	public String getDescription() {
		return description;
	}
	/**
	 * @brief Method for determine the description of the Product
	 * @param description description of the product
	 */
	@Transient
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @brief Method for get the value of the name variable
	 * @return String
	 */
	@Transient
	public String getName() {
		return name;
	}
	/**
	 * @brief Method for determine the name of the Product
	 * @param name name of the product
	 */
	@Transient
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @brief Method for get the value of the idProductvariable
	 * @return int
	 */
	public int getIdProduct() {
		return idProduct;
	}
	/**
	 * @brief Method for determine the id of the Product
	 * @param idProduct id of the product
	 */
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	/**
	 * @brief Method for get the value of the idProductType variable
	 * @return int
	 */
	public int getProductType() {
		return productType;
	}
	/**
	 * @brief Method for determine the type of the product
	 * @param productType type of the product
	 */
	public void setProductType(int productType) {
		this.productType = productType;
	}
	/**
	 * @brief Method for get the value of the position variable
	 * @return int
	 */
	public int getPosition() {
		return position;
	}
	/**
	 * @brief Method for determine the position of the product
	 * @param position position of the product
	 */
	public void setPosition(int position) {
		this.position = position;
	}

}
