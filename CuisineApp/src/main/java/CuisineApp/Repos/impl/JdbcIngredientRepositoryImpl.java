package CuisineApp.Repos.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import CuisineApp.Data.Ingredient;
import CuisineApp.Repos.intf.IngredientRepository;

@Repository
public abstract class JdbcIngredientRepositoryImpl {
	
//	private JdbcTemplate jdbcTemplate;
//	
////	@Autowired
//	public JdbcIngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//	public Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException{
//		return new Ingredient(row.getString("id"),
//				row.getString("name"), 
//				Ingredient.Type.valueOf(row.getString("type")));
//	}
//	
//
//	@Override
//	public Iterable<Ingredient> findByAll() {
//		// TODO Auto-generated method stub
//		return jdbcTemplate.query("select * from ingredient", this::mapRowToIngredient);
//	}
//
//	@Override
//	public Optional<Ingredient> findById(String id) {
//		// TODO Auto-generated method stub
//		List<Ingredient> results = jdbcTemplate.query("select id,name,type from ingredient where id=?",this::mapRowToIngredient,id);
//		return results.size() == 0 ? 
//				Optional.empty():
//					Optional.of(results.get(0));
//	}
//
//	@Override
//	public Ingredient save(Ingredient ingredient) {
//		// TODO Auto-generated method stub
//		jdbcTemplate.update("insert into ingredient(id, name, type) values (?,?,?)",
//				ingredient.getId(),
//				ingredient.getName(),
//				ingredient.getType().toString());
//		return ingredient;
//	}
//	
//	

}
