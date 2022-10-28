package CuisineApp.Converter;
import CuisineApp.Data.Ingredient.Type;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import CuisineApp.Data.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String,Ingredient>{

	public Map<String,Ingredient> ingredientMap = new HashMap<String,Ingredient>();

	public  IngredientByIdConverter() {

		ingredientMap.put("FLTO", 
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		ingredientMap.put("COTO", 
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		ingredientMap.put("GRBF", 
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
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
	}

	@Override
	public Ingredient convert(String id) {
		// TODO Auto-generated method stub
		return ingredientMap.get(id);
	}

}
