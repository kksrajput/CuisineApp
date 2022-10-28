package CuisineApp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import CuisineApp.Data.Cuisine;
import CuisineApp.Data.CuisineOrder;
import CuisineApp.Data.Ingredient.Type;
import CuisineApp.Data.Ingredient;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("cuisineOrder")
public class DesignCuisineController {

	private static final org.slf4j.Logger log =
			org.slf4j.LoggerFactory.getLogger(DesignCuisineController.class);

	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE),
				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE),
				new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);

		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
					filterByType(ingredients, type));
		}
	}

	@ModelAttribute(name = "cuisineOrder")
	public CuisineOrder order() {
		return new CuisineOrder();
	}

	@ModelAttribute(name = "cuisine")
	public Cuisine cuisine() {
		return new Cuisine();
	}

	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	@PostMapping
	public String processCuisine(Cuisine cu, @ModelAttribute CuisineOrder cuisineOrder) {
		cuisineOrder.addCuisine(cu);
		  log.info("Processing Cuisine: {}", cu);
		return "redirect:/orders/current";
	}

	private Iterable<Ingredient> filterByType(
			List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
	
	

}
