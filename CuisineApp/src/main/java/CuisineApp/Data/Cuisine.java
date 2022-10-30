package CuisineApp.Data;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
 
@Data
public class Cuisine {
	
	private long id;
	
	private Date createdAt = new Date();
 
  @NotNull
  @Size(min = 3, message = "Name must be 3 characters long")
  private String name;
  
  @NotNull
  @Size(min = 1, message = "Select at least 1 ingredient")
  private List<Ingredient> ingredients;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Ingredient> getIngredients() {
	return ingredients;
}

public void setIngredients(List<Ingredient> ingredients) {
	this.ingredients = ingredients;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
 
}