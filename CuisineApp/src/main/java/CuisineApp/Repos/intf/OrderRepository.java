package CuisineApp.Repos.intf;

import CuisineApp.Data.CuisineOrder;

public interface OrderRepository {
	
	CuisineOrder save(CuisineOrder order);
}
