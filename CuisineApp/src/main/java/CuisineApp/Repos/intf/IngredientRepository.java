package CuisineApp.Repos.intf;

import java.util.Optional;

import CuisineApp.Data.Ingredient;

public interface IngredientRepository {

	Iterable<Ingredient> findByAll();

	Optional<Ingredient> findById(String id);

	Ingredient save(Ingredient ingredient);


}
