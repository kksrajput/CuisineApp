package CuisineApp.Repos.impl;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import CuisineApp.Data.Cuisine;
import CuisineApp.Data.CuisineOrder;
import CuisineApp.Data.Ingredient;
import CuisineApp.Data.IngredientRef;
import CuisineApp.Repos.intf.OrderRepository;

@Repository
public class JdbcOrderRepoImpl implements OrderRepository{
	
	private JdbcOperations jdbcOperations;
	
	public JdbcOrderRepoImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
	

	@Override
	@Transactional
	public CuisineOrder save(CuisineOrder order) {
		// TODO Auto-generated method stub
		PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
				"insert into Cuisine_order"
				+"(delivery_name,delivery_street,delivery_city,delivery_state,delivery_zip,"+
						"cc_number,cc_expiration,cc_cvv,placed_at)"+ 
				"values(?,?,?,?,?,?,?,?,?)",
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
				Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP
				);
		
		pscf.setReturnGeneratedKeys(true);//saved order Ids
		
		order.setPlacedAt(new Date());
		PreparedStatementCreator psc =  pscf.newPreparedStatementCreator(
				Arrays.asList(order.getDeliveryName(),
						order.getDeliveryStreet(),
						order.getDeliveryCity(),
						order.getDeliveryState(),
						order.getDeliveryZip(),
						order.getCcNumber(),
						order.getCcExpiration(),
						order.getCcCVV(),
						order.getPlacedAt())	
				);
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcOperations.update(psc,keyHolder);	//save the value of the order id	
		long orderId = keyHolder.getKey().longValue();
		order.setId(orderId);
		List<Cuisine> cuisineValues = order.getCuisines();
		int i= 0;
		for(Cuisine cu:cuisineValues) {
			saveCuisine(orderId,i++,cu);
		}
		return order;
	}
	
	private long saveCuisine(Long orderId,int orderKey, Cuisine cuisine) {
		cuisine.setCreatedAt(new Date());
		PreparedStatementCreatorFactory pscf = 
				new PreparedStatementCreatorFactory(
						"insert into Cuisine"
						+"(name,created_at,cuisine_order,cuisine_key)"
						+"values(?,?,?,?)" ,Types.VARCHAR,Types.TIMESTAMP,
						Types.LONGNVARCHAR,Types.LONGVARCHAR
						);
		pscf.setReturnGeneratedKeys(true);
		
		PreparedStatementCreator psc = pscf.newPreparedStatementCreator(Arrays.asList(
				cuisine.getName(),
				cuisine.getCreatedAt(),
				orderId,
				orderKey
				));
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcOperations.update(psc,keyHolder);
		long cuisineId = keyHolder.getKey().longValue();
		cuisine.setId(cuisineId);
		saveIngredientRefs(cuisineId,cuisine.getIngredients());
		return orderKey;
		
	}
	
	private void saveIngredientRefs(long cuisineId,List<Ingredient> ingredientRefs) {
		int key = 0;
		for(Ingredient ingredientRef:ingredientRefs) {
			jdbcOperations.update("insert into Ingredient_Ref(ingredient,cuisine,cuisine_key)"
					+"values(?,?,?)",
			ingredientRef.getName(),cuisineId,key++);
		}
	}

}
