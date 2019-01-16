/** @file OrderDAO.java
 *  @brief OrderDAO dao
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 18/12/2018
 */

/** @brief package dao
 */package dao;

 /** @brief Libraries
  */
import model.Order;
/**
 * @brief Interface OrderDAO
 */
public interface OrderDAO {
	/**
	 * @brief Method for getting the order having the id
	 * @param id the idOrder
	 * @return Order
	 */
	public Order getOrderDetailsById(int id);
	/**
	 * @brief Method for getting the id of the last order of the table
	 * @return int
	 */
	public int getLastOrderId();
	
	/**
	 * @brief Method for adding a new order return if it was succesfull or not
	 * @param order an Order
	 * @return boolean
	 */
	public boolean addOrder(Order order);
}
