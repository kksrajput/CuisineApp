package CuisineApp.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import CuisineApp.Data.CuisineOrder;
import CuisineApp.Repos.intf.OrderRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("cuisineOrder")
public class OrdersController {
	
	private static final org.slf4j.Logger log =
			org.slf4j.LoggerFactory.getLogger(DesignCuisineController.class);
	
	private OrderRepository orderRepo;
	public OrdersController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	@PostMapping
	public String processOrder(@Valid CuisineOrder cuisineOrder, Errors errors, SessionStatus sessionStatus) {
		if(errors.hasErrors()) {
			return "orderForm";
		}
		orderRepo.save(cuisineOrder);
		log.info("Order Done {}",cuisineOrder);
		sessionStatus.setComplete();
		return "redirect:/";
	}
	

}
