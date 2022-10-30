package CuisineApp.Converter;
import CuisineApp.Data.Ingredient.Type;
import CuisineApp.Repos.intf.IngredientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import CuisineApp.Data.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String,Ingredient>{

	//	public Map<String,Ingredient> ingredientMap = new HashMap<String,Ingredient>();

	private IngredientRepository ingreRepo;

	@Autowired
	public IngredientByIdConverter(IngredientRepository ingreRepo) {
		
		this.ingreRepo = ingreRepo;
	}


	/*public IngredientByIdConverter() {

		ingredientMap.put("FLTO", 
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		ingredientMap.put("COTO", 
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		ingredientMap.put("GRE", 
				new Ingredient("GRE", "Ground Egg", Type.PROTEIN));
		ingredientMap.put("CARN", 
				new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		ingredientMap.put("TMTO", 
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		ingredientMap.put("LETC", 
				new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		ingredientMap.put("CHED", 
				new Ingredient("CHED", "Cheddar", Type.CHEESE));
		ingredientMap.put("JACK", 
				new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		ingredientMap.put("SLSA", 
				new Ingredient("SLSA", "Salsa", Type.SAUCE));
		ingredientMap.put("SRCR", 
				new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	}*/

	@Override
	public Ingredient convert(String id) {
		// TODO Auto-generated method stub
		//		return ingredientMap.get(id);
		return ingreRepo.findById(id).orElse(null);
	}

}
