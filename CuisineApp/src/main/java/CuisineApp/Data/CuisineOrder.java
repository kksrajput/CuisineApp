package CuisineApp.Data;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;
 
@Data
public class CuisineOrder {
 
  private String deliveryName;
  private String deliveryStreet;
  private String deliveryCity;
  private String deliveryState;
  private String deliveryZip;
  private String ccNumber;
  private String ccExpiration;
  private String ccCVV;
 
  private List<Cuisine> cuisines = new ArrayList<>();
 
  public void addTaco(Cuisine cu) {
    this.cuisines.add(cu);
  }
}