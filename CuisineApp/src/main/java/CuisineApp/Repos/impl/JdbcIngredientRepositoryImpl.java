package CuisineApp.Repos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import CuisineApp.Data.Ingredient;
import CuisineApp.Repos.intf.IngredientRepository;

@Repository
public class JdbcIngredientRepositoryImpl implements IngredientRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcIngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException{
		return new Ingredient(row.getString("id"), row.getString("name"), Ingredient.Type.valueOf(row.getString("type")));
	}

	@Override
	public Iterable<Ingredient> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
