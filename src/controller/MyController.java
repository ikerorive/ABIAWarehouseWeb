/** @file MyController.java
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

@Controller
@Scope("session")
public class MyController {

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	private RoleService roleService;

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Autowired
	private VehicleService vehicleService;

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@Autowired
	private VehicleStatusService vehicleStatusService;

	public VehicleStatusService getVehicleStatusService() {
		return vehicleStatusService;
	}

	public void setVehicleStatusService(VehicleStatusService vehicleStatusService) {
		this.vehicleStatusService = vehicleStatusService;
	}

	@Autowired
	private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	private ProductTypeService productTypeService;

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	@Autowired
	private PositionService positionService;

	public PositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	@Autowired
	private PosTypeService posTypeService;

	public PosTypeService getPosTypeService() {
		return posTypeService;
	}

	public void setPosTypeService(PosTypeService posTypeService) {
		this.posTypeService = posTypeService;
	}

	@Autowired
	private PositionRelationService positionRelationService;

	public PositionRelationService getPositionRelationService() {
		return positionRelationService;
	}

	public void setPositionRelationService(PositionRelationService positionRelationService) {
		this.positionRelationService = positionRelationService;
	}

	@Autowired
	private OrderService orderService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	private OrderStatusService orderStatusService;

	public OrderStatusService getOrderStatusService() {
		return orderStatusService;
	}

	public void setOrderStatusService(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}

	@Autowired
	private TaskService taskService;

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Autowired
	private TaskStatusService taskStatusService;

	public TaskStatusService getTaskStatusService() {
		return taskStatusService;
	}

	public void setTaskStatusService(TaskStatusService taskStatusService) {
		this.taskStatusService = taskStatusService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("userCredential", new UserCredential());
		return "login";
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("userCredential") UserCredential userCredential,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcomeCustomer");
		User user = getUserService().validateUserCredential(userCredential.getUsername(), userCredential.getPassword());
		if (user != null) {
			session.setAttribute("user", user);

			if (session.getAttribute("user") != null) {
				User user2 = (User) session.getAttribute("user");
				System.out.println("username " + user2.getUsername());
			}
			int role = user.getIdRole();
			if (role == 3) {
				modelAndView = new ModelAndView("welcomeManager");
			} else if (role == 2) {
				modelAndView = new ModelAndView("welcomeOperator");
			}
			modelAndView.addObject("user", user);
			// return modelAndView;
		} else {
			System.out.println();
			modelAndView = new ModelAndView("notFound");
		}

		//// DESDE AQUI PARA CARGAR DATOS DE PRODUCTOS
		HashMap<Integer, ProductType> hmap = getProductTypeService().getProductTypeMap();
		ArrayList<Product> pr = getProductService().getProducts();
		for (Product o : pr) {

			o.setName(hmap.get(o.getProductType()).getName());
			o.setDescription(hmap.get(o.getProductType()).getDescription());
			System.out.println("Id Product " + o.getIdProduct());
			System.out.println(" Product " + o.getName());
			System.out.println(" Product " + o.getDescription());
			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));
		System.out.println("sorted");
		modelAndView.addObject("products", pr);
		///// HASTA AQUI

		return modelAndView;
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("register");
		}

		getUserService().registerUser(user);
		ModelAndView modelAndView = new ModelAndView("home");
		// modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@ModelAttribute
	public void headerMessage(Model model) {
		model.addAttribute("headerMessage", "Welcome");

	}

	@RequestMapping(value = "/knowmore", method = RequestMethod.GET)
	public String knowmorePage(Model model) {
		model.addAttribute("userCredential", new UserCredential());
		HashMap<Integer, ProductType> hmap = getProductTypeService().getProductTypeMap();
		ArrayList<Product> pr = getProductService().getProducts();
		for (Product o : pr) {

			o.setName(hmap.get(o.getProductType()).getName());
			o.setDescription(hmap.get(o.getProductType()).getDescription());
			System.out.println("Id Product " + o.getIdProduct());
			System.out.println(" Product " + o.getName());
			System.out.println(" Product " + o.getDescription());
			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));
		System.out.println("sorted");
		model.addAttribute("products", pr);
		return "knowmore";
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String orderPage(Model model) {
		model.addAttribute("order", new Order());
		return "order";
	}

	@RequestMapping(value = "/orderSuccess", method = RequestMethod.POST)
	public ModelAndView orderSuccess(@Valid @ModelAttribute("order") Order order, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("order");
		}

		getOrderService().createOrder(order);
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public String taskPage(Model model) {
		model.addAttribute("task", new Task());
		return "task";
	}

	@RequestMapping(value = "/taskSuccess", method = RequestMethod.POST)
	public ModelAndView taskSuccess(@Valid @ModelAttribute("task") Task task, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("task");
		}

		getTaskService().createTask(task);
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@RequestMapping(value = "/selectProducts", method = RequestMethod.POST)
	public void validateSymbol(WebRequest webRequest, Model model, HttpServletRequest request,
			HttpServletResponse response, @RequestParam String[] data, HttpSession session) throws IOException {
		Order order = new Order();
		if (session.getAttribute("user") != null) {
			User user2 = (User) session.getAttribute("user");
			System.out.println("username " + user2.getUsername());
			order.setIdUser(user2.getIdUser());
		} else {
			order.setIdUser(4);
		}
		order.setIdOrderStatus(1);
		order.setDestino(Integer.parseInt(data[0]));
		order.setOrderDesc(data[1]);
		getOrderService().createOrder(order);
		int id = getOrderService().getLastId();
		System.out.println("LAST ID " + id);
		// Order order= getOrderService().
		System.out.println("PRUEBA   " + data[0]);
		// response.encodeRedirectURL("/SpringMVCFormValidationPruebas/selectProducts");
		for (int i = 2; i < data.length; i++) {
			Task task = new Task();
			task.setIdOrder(id);
			task.setIdProduct(Integer.parseInt(data[i]));
			task.setIdStatus(1);
			task.setIdVehicle(0);
			getTaskService().createTask(task);
		}
		
	}

	@RequestMapping(value = "/productSelection", method = RequestMethod.GET)
	public String productSelection(Model model) {
		// model.addAttribute("userCredential", new UserCredential());
		HashMap<Integer, ProductType> hmap = getProductTypeService().getProductTypeMap();
		ArrayList<Product> pr = getProductService().getProducts();
		ArrayList<Position> pos = getPositionService().getPositionByPositionId(3);
		System.out.println("------------------------------------------------POSITION LIST " + pos);
		for (Product o : pr) {

			o.setName(hmap.get(o.getProductType()).getName());
			o.setDescription(hmap.get(o.getProductType()).getDescription());
			System.out.println("Id Product " + o.getIdProduct());
			System.out.println(" Product " + o.getName());
			System.out.println(" Product " + o.getDescription());
			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));
		System.out.println("sorted");
		model.addAttribute("products", pr);
		model.addAttribute("positions", pos);
		return "productSelection";
	}

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
		System.out.println("JSON  " + json);
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
		session.setAttribute("jsonPrueba", json.toString());
			
		
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

		System.out.println("JSON  " + json);
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
		System.out.println("JSON  " + json);
		return "workstationInfo";
	}
	
	
	
}
