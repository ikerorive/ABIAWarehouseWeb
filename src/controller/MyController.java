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
 * @brief Class MyController
 */
@Controller
@Scope("session")
public class MyController {

	/**
	 * @brief Attributes
	 */
	@Autowired
	private UserService userService;

	/**
	 * @brief Method for determine the userService
	 * @param userService userService
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @brief Method for get the value of the userService variable
	 * @return UserService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private RoleService roleService;

	/**
	 * @brief Method for get the value of the roleService variable
	 * @return RoleService
	 */
	public RoleService getRoleService() {
		return roleService;
	}

	/**
	 * @brief Method for determine the roleService
	 * @param roleService roleService
	 */
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private VehicleService vehicleService;

	/**
	 * @brief Method for get the value of the vehicleService variable
	 * @return VehicleService
	 */
	public VehicleService getVehicleService() {
		return vehicleService;
	}

	/**
	 * @brief Method for determine the vehicleService
	 * @param vehicleService vehicleService
	 */
	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private VehicleStatusService vehicleStatusService;

	/**
	 * @brief Method for get the value of the vehicleStatusService variable
	 * @return VehicleStatusService
	 */
	public VehicleStatusService getVehicleStatusService() {
		return vehicleStatusService;
	}

	/**
	 * @brief Method for determine the vehicleStatusService
	 * @param vehicleStatusService vehicleStatusService
	 */
	public void setVehicleStatusService(VehicleStatusService vehicleStatusService) {
		this.vehicleStatusService = vehicleStatusService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private ProductService productService;

	/**
	 * @brief Method for get the value of the productService variable
	 * @return ProductService
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * @brief Method for determine the productService
	 * @param productService productService
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * @brief Method for get the value of the productTypeService variable
	 * @return ProductTypeService
	 */
	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	/**
	 * @brief Method for determine the productTypeService
	 * @param productTypeService productTypeService
	 */
	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private PositionService positionService;

	/**
	 * @brief Method for get the value of the positionService variable
	 * @return PositionService
	 */
	public PositionService getPositionService() {
		return positionService;
	}

	/**
	 * @brief Method for determine the positionService
	 * @param positionService positionService
	 */
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private PosTypeService posTypeService;

	/**
	 * @brief Method for get the value of the postTypeService variable
	 * @return PosTypeService
	 */
	public PosTypeService getPosTypeService() {
		return posTypeService;
	}

	/**
	 * @brief Method for determine the posTypeService
	 * @param posTypeService posTypeService
	 */
	public void setPosTypeService(PosTypeService posTypeService) {
		this.posTypeService = posTypeService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private PositionRelationService positionRelationService;

	/**
	 * @brief Method for get the value of the positionRelationService variable
	 * @return PositionRelationService
	 */
	public PositionRelationService getPositionRelationService() {
		return positionRelationService;
	}

	/**
	 * @brief Method for determine the positionRelationService
	 * @param positionRelationService positionRelationService
	 */
	public void setPositionRelationService(PositionRelationService positionRelationService) {
		this.positionRelationService = positionRelationService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * @brief Method for get the value of the orderService variable
	 * @return OrderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @brief Method for determine the orderService
	 * @param orderService orderService
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private OrderStatusService orderStatusService;

	/**
	 * @brief Method for get the value of the orderStatusService variable
	 * @return OrderStatusService
	 */
	public OrderStatusService getOrderStatusService() {
		return orderStatusService;
	}

	/**
	 * @brief Method for determine the OrderStatusService
	 * @param orderStatusService orderStatusService
	 */
	public void setOrderStatusService(OrderStatusService orderStatusService) {
		this.orderStatusService = orderStatusService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private TaskService taskService;

	/**
	 * @brief Method for get the value of the taskService variable
	 * @return TaskService
	 */
	public TaskService getTaskService() {
		return taskService;
	}

	/**
	 * @brief Method for determine the taskService
	 * @param taskService taskService
	 */
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 * @brief Attributes
	 */
	@Autowired
	private TaskStatusService taskStatusService;

	/**
	 * @brief Method for get the value of the taskStatusService variable
	 * @return TaskStatusService
	 */
	public TaskStatusService getTaskStatusService() {
		return taskStatusService;
	}

	/**
	 * @brief Method for determine the taskStatusService
	 * @param taskStatusService taskStatusService
	 */
	public void setTaskStatusService(TaskStatusService taskStatusService) {
		this.taskStatusService = taskStatusService;
	}

	@RequestMapping(value = "/404")
	public String error404() {
		// DO stuff here
		return "404";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		// System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		// System.out.println("" + System.getProperty("user.dir"));
		return "home";
	}
	
	@RequestMapping(value = "logOff", method = RequestMethod.GET)
	public String logOff( HttpSession session) {
		session.setAttribute("user", null);
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
				// System.out.println("username " + user2.getUsername());
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
			// System.out.println();
			modelAndView = new ModelAndView("notFound");
		}

		//// DESDE AQUI PARA CARGAR DATOS DE PRODUCTOS
		HashMap<Integer, ProductType> hmap = getProductTypeService().getProductTypeMap();
		ArrayList<Product> pr = getProductService().getProducts();
		for (Product o : pr) {

			o.setName(hmap.get(o.getProductType()).getName());
			o.setDescription(hmap.get(o.getProductType()).getDescription());
			// System.out.println("Id Product " + o.getIdProduct());
			// System.out.println(" Product " + o.getName());
			// System.out.println(" Product " + o.getDescription());
			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));
		// System.out.println("sorted");
		modelAndView.addObject("products", pr);

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

	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String registerUserPage(Model model) {
		model.addAttribute("user", new User());
		return "registerUser";
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
			// System.out.println("Id Product " + o.getIdProduct());
			// System.out.println(" Product " + o.getName());
			// System.out.println(" Product " + o.getDescription());
			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));
		// System.out.println("sorted");
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

			// System.out.println("username " + user2.getUsername());

			order.setIdUser(user2.getIdUser());
		} else {
			order.setIdUser(4);
		}
		order.setIdOrderStatus(1);
		order.setDestino(Integer.parseInt(data[0]));
		order.setOrderDesc(data[1]);
		getOrderService().createOrder(order);
		int id = getOrderService().getLastId();
		// System.out.println("LAST ID " + id);
		// Order order= getOrderService().
		// System.out.println("PRUEBA " + data[0]);
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

		// System.out.println("------------------------------------------------POSITION
		// LIST " + pos);

		for (Product o : pr) {

			o.setName(hmap.get(o.getProductType()).getName());
			o.setDescription(hmap.get(o.getProductType()).getDescription());

			// System.out.println("Id Product " + o.getIdProduct());
			// System.out.println(" Product " + o.getName());
			// System.out.println(" Product " + o.getDescription());

			// en cada iteraci�n "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
		// Collections.sort(pr);
		pr.sort(Comparator.comparing(Product::getProductType));

		// System.out.println("sorted");

		model.addAttribute("products", pr);
		model.addAttribute("positions", pos);
		return "productSelection";
	}


	
}
