/** @file MyControllerForCharts.java
 *  @brief Controller
 *  @authors
 *  Name          | Surname         | Email                                |
 *  ------------- | -------------- | ------------------------------------ |
 *  Iker	      | Orive          | iker.orive@alumni.mondragon.edu     |
 *  Ander	      | Lanas          | ander.lanas@alumni.mondragon.edu     |
 *  @date 12/12/2018
 */

/** @brief package controller
 */
package controller;

/** @brief Libraries
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import dao.impl.GetJSON;
import model.Vehicle;
import model.Order;
import model.Position;
import model.Product;
import model.ProductType;
import model.Task;
import model.User;
import model.UserCredential;

import model.VehicleStatus;
import service.PosTypeService;
import service.PositionRelationService;
import service.PositionService;
import service.ProductService;
import service.ProductTypeService;

import service.OrderService;
import service.OrderStatusService;

import service.RoleService;
import service.TaskService;
import service.TaskStatusService;
import service.UserService;
import service.VehicleService;
import service.VehicleStatusService;

/**
 * @brief Class MyControllerForCharts
 */
@Controller
@Scope("session")
public class MyControllerForCharts {

	@RequestMapping(value = "/currentOrders", method = RequestMethod.GET)
	public String currentOrders(Model model, HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws IOException {
		User user2 = (User) session.getAttribute("user");
		GetJSON getJson = new GetJSON();
		JSONArray json = getJson.getJSONFromQuery(
				"SELECT\r\n" + "  user.USERNAME,\r\n" + "  `order`.ORDERDESC,\r\n" + "  taskstatus.STATUSNAME,\r\n"
						+ "  producttype.NAME,\r\n" + "  `order`.DATE,\r\n" + "YEAR(`order`.DATE) AS YEAR\r\n"
						+ "FROM task\r\n" + "  INNER JOIN `order`\r\n" + "    ON task.idORDER = `order`.idORDER\r\n"
						+ "  INNER JOIN user\r\n" + "    ON `order`.idUSER = user.idUSER\r\n"
						+ "  INNER JOIN taskstatus\r\n" + "    ON task.idSTATUS = taskstatus.idTASKSTATUS\r\n"
						+ "  INNER JOIN product\r\n" + "    ON task.idPRODUCT = product.idPRODUCT\r\n"
						+ "  INNER JOIN producttype\r\n" + "    ON product.PRODUCTTYPE = producttype.idPRODUCTTYPE\r\n"
						+ " WHERE user.idUSER='" + user2.getIdUser() + "';");
		//System.out.println("JSON  " + json);
		/*
		 * ServletContext context =request.getServletContext(); String path =
		 * context.getRealPath("/");
		 * System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + path); try
		 * (FileWriter file = new FileWriter(path+"resources\\jeje.json")) {
		 * 
		 * file.write(json.toString()); file.flush();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		// response.sendRedirect("currentOrders");

		// return "{ \"data\" : " + json.toString() + "}";
		session.setAttribute("dataCurrentOrders", json.toString());
		//System.out.println("current orders work");
		return "currentOrders";
	}

	@RequestMapping(value = "/currentOrdersAll", method = RequestMethod.GET)
	public String currenOrdersAll(Model model) {
		// OPERATOR
		GetJSON getJson = new GetJSON();
		JSONArray jsonTask = getJson.getJSONFromQuery("SELECT\r\n" + "  user.USERNAME,\r\n" + "  `order`.ORDERDESC,\r\n"
				+ "  taskstatus.STATUSDESC,\r\n" + "  producttype.NAME,\r\n" + "  YEAR(`order`.DATE) AS YEAR,\r\n"
				+ "  `order`.DATE\r\n" + "FROM task\r\n" + "  INNER JOIN `order`\r\n"
				+ "    ON task.idORDER = `order`.idORDER\r\n" + "  INNER JOIN user\r\n"
				+ "    ON `order`.idUSER = user.idUSER\r\n" + "  INNER JOIN taskstatus\r\n"
				+ "    ON task.idSTATUS = taskstatus.idTASKSTATUS\r\n" + "  INNER JOIN product\r\n"
				+ "    ON task.idPRODUCT = product.idPRODUCT\r\n" + "  INNER JOIN producttype\r\n"
				+ "    ON product.PRODUCTTYPE = producttype.idPRODUCTTYPE\r\n" + "WHERE task.idSTATUS!='3';");
		JSONArray jsonVehicle = getJson
				.getJSONFromQuery("SELECT\r\n" + "  `position`.POSNAME,\r\n" + "  vehiclestatus.STATUSNAME,\r\n"
						+ "  vehicle.idVEHICLE\r\n" + "FROM vehicle\r\n" + "  INNER JOIN vehiclestatus\r\n"
						+ "    ON vehicle.idVEHICLESTATUS = vehiclestatus.idVEHICLESTATUS\r\n"
						+ "  INNER JOIN `position`\r\n" + "    ON vehicle.idPOSITION = `position`.idPOSITION;");
		JSONArray jsonProduct = getJson.getJSONFromQuery("SELECT\r\n" + "  product.idPRODUCT,\r\n"
				+ "  `position`.POSNAME,\r\n" + "  producttype.NAME\r\n" + "FROM product\r\n"
				+ "  INNER JOIN `position`\r\n" + "    ON product.`POSITION` = `position`.idPOSITION\r\n"
				+ "  INNER JOIN producttype\r\n" + "    ON product.PRODUCTTYPE = producttype.idPRODUCTTYPE;");
		System.out.println("JSON  " + jsonVehicle);
		return "currentOrdersAll";
	}

	@RequestMapping(value = "/logistic", method = RequestMethod.GET)
	public String logistic(Model model) {
		// OPERATOR

		return "logistic";
	}

	@RequestMapping(value = "/orderHistoryAll", method = RequestMethod.GET)
	public String orderHistoryAll(Model model) {
		GetJSON getJson = new GetJSON();

		JSONArray json = getJson.getJSONFromQuery(
				"SELECT\r\n" + "  user.USERNAME,\r\n" + "  `order`.ORDERDESC,\r\n" + "  taskstatus.STATUSDESC,\r\n"
						+ "  producttype.NAME,\r\n" + "  YEAR(`order`.DATE) AS YEAR,\r\n" + "  `order`.DATE\r\n"
						+ "FROM task\r\n" + "  INNER JOIN `order`\r\n" + "    ON task.idORDER = `order`.idORDER\r\n"
						+ "  INNER JOIN user\r\n" + "    ON `order`.idUSER = user.idUSER\r\n"
						+ "  INNER JOIN taskstatus\r\n" + "    ON task.idSTATUS = taskstatus.idTASKSTATUS\r\n"
						+ "  INNER JOIN product\r\n" + "    ON task.idPRODUCT = product.idPRODUCT\r\n"
						+ "  INNER JOIN producttype\r\n" + "    ON product.PRODUCTTYPE = producttype.idPRODUCTTYPE;");

		//System.out.println("JSON  " + json);
		return "orderHistoryAll";
	}

	@RequestMapping(value = "/vehicleInfo", method = RequestMethod.GET)
	public String vehicleInfo(Model model) {
		// SELECT * FROM warehouse.vehicle;
		GetJSON getJson = new GetJSON();
		JSONArray jsonVehicle = getJson
				.getJSONFromQuery("SELECT\r\n" + "  `position`.POSNAME,\r\n" + "  vehiclestatus.STATUSNAME,\r\n"
						+ "  vehicle.idVEHICLE\r\n" + "FROM vehicle\r\n" + "  INNER JOIN vehiclestatus\r\n"
						+ "    ON vehicle.idVEHICLESTATUS = vehiclestatus.idVEHICLESTATUS\r\n"
						+ "  INNER JOIN `position`\r\n" + "    ON vehicle.idPOSITION = `position`.idPOSITION;");
		JSONArray jsonVehicleTask = getJson.getJSONFromQuery("SELECT\r\n" + "  task.idVEHICLE,\r\n"
				+ "  `order`.ORDERDESC,\r\n" + "  YEAR(`task`.FINISHDATE) AS YEAR,\r\n" + "  task.FINISHDATE,\r\n"
				+ "  `position`.POSNAME\r\n" + "FROM task\r\n" + "  INNER JOIN `order`\r\n"
				+ "    ON task.idORDER = `order`.idORDER\r\n" + "  INNER JOIN `position`\r\n"
				+ "    ON `order`.DESTINO = `position`.idPOSITION;");
		return "vehicleInfo";
	}

	@RequestMapping(value = "/workstationInfo", method = RequestMethod.GET)
	public String workstationInfo(Model model) {
		GetJSON getJson = new GetJSON();
		JSONArray json = getJson
				.getJSONFromQuery("SELECT\r\n" + "  product.idPRODUCT,\r\n" + "  product.`POSITION`,\r\n"
						+ "  `position`.POSNAME,\r\n" + "  producttype.NAME\r\n" + "FROM product\r\n"
						+ "  INNER JOIN `position`\r\n" + "    ON product.`POSITION` = `position`.idPOSITION\r\n"
						+ "  INNER JOIN producttype\r\n" + "    ON product.PRODUCTTYPE = producttype.idPRODUCTTYPE;");
		//System.out.println("JSON  " + json);
		return "workstationInfo";
	}

}
