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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Vehicle;
import model.Order;
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
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("login");
		}

		ModelAndView modelAndView = new ModelAndView("welcomeCustomer");
		User user = getUserService().validateUserCredential(userCredential.getUsername(), userCredential.getPassword());
		if (user != null) {
			int role = user.getIdRole();
			if (role == 3) {
				modelAndView = new ModelAndView("welcomeManager");
			} else if (role == 2) {
				modelAndView = new ModelAndView("welcomeOperator");
			}
			modelAndView.addObject("user", user);
			return modelAndView;
		} else {
			System.out.println();
			modelAndView = new ModelAndView("notFound");
		}
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
			// en cada iteración "o" se refiere a un objeto del arreglo para todos objetos
			// en el arreglo
		}
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

}
