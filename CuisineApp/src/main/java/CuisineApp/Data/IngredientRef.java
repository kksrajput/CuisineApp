package CuisineApp.Data;

import lombok.Data;

@Data
public class IngredientRef {
	private String ingredient;

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
}
