package CuisineApp.Repos.intf;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import CuisineApp.Data.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient,String>{

//	Iterable<Ingredient> findByAll();
	Iterable<Ingredient> findAll();

	Optional<Ingredient> findById(String id);

	Ingredient save(Ingredient ingredient);


}
