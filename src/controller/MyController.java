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
import model.VehicleStatus;
import service.PosTypeService;
import service.PositionRelationService;
import service.PositionService;
import service.ProductService;
import service.ProductTypeService;
import service.RoleService;
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
			System.out.println("\n"+getRoleService().validateRole(3).getRoledesc()+"\n");
			System.out.println("AAAAAAAAAAAAAAAAAAAAA  " + role);
			System.out.println("\n"+getVehicleService().validateVehicle(7).getIdPosition()+"\n");
			System.out.println("BBBBBBBBBBBBBBBBBBBBB " + role);
			System.out.println("\n"+getVehicleStatusService().validateVehicleStatus(1).getStatusName()+"\n");
			System.out.println("CCCCCCCCCCCCCCCCCCCCC  " + role);
			System.out.println("\n"+getProductService().validateProduct(8).getProductType()+"\n");
			System.out.println("DDDDDDDDDDDDDDDDDDDDD  " + role);
			System.out.println("\n"+getProductTypeService().validateProductType(1).getName()+"\n");
			System.out.println("EEEEEEEEEEEEEEEEEEEEE  " + role);
			System.out.println("\n"+getPositionService().validatePosition(1).getPosName()+"\n");
			System.out.println("FFFFFFFFFFFFFFFFFFFFF  " + role);
			System.out.println("\n"+getPosTypeService().validatePosType(1).getName()+"\n");
			System.out.println("GGGGGGGGGGGGGGGGGGGGG  " + role);
			System.out.println("\n"+getPositionRelationService().validatePositionRelation(205).getIdDestino()+"\n");
			System.out.println("HHHHHHHHHHHHHHHHHHHHH  " + role);
			
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
