package CuisineApp.Repos.intf;
import org.springframework.data.repository.CrudRepository;
import CuisineApp.Data.CuisineOrder;

public interface OrderRepository extends CrudRepository<CuisineOrder,Long>{
	
	CuisineOrder save(CuisineOrder order);
}
