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
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Vehicle;
import model.User;
import model.UserCredential;
import service.OrderService;
import service.OrderStatusService;
import service.RoleService;
import service.TaskService;
import service.TaskStatusService;
import service.UserService;
import service.VehicleService;

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
		/*	System.out.println("\n role sservice " + getRoleService().validateRole(3).getRoledesc() + "\n");
			System.out.println("\n vehicle " + getVehicleService().validateVehicle(7).getIdPosition() + "\n");
			System.out.println("\n order " + getOrderService().validateOrder(10).getOrderDesc() + "\n");
			System.out.println("\n order status " + getOrderStatusService().validateOrderStatus(2).getStatusDesc() + "\n");*/
			/*System.out.println("\n task 13 8 " + getTaskService().validateOrder(13, 8).getFinishDate()+ "\n");
			System.out.println("\n task 14 11 " + getTaskService().validateOrder(14, 11).getFinishDate()+ "\n");
			*/
			System.out.println("\n taskStatus " + getTaskStatusService().validateTaskStatus(1).getStatusDesc()+ "\n");
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
}
