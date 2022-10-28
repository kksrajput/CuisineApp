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
 
  public void addCuisine(Cuisine cu) {
    this.cuisines.add(cu);
  }

public String getDeliveryName() {
	return deliveryName;
}

public void setDeliveryName(String deliveryName) {
	this.deliveryName = deliveryName;
}

public String getDeliveryStreet() {
	return deliveryStreet;
}

public void setDeliveryStreet(String deliveryStreet) {
	this.deliveryStreet = deliveryStreet;
}

public String getDeliveryCity() {
	return deliveryCity;
}

public void setDeliveryCity(String deliveryCity) {
	this.deliveryCity = deliveryCity;
}

public String getDeliveryState() {
	return deliveryState;
}

public void setDeliveryState(String deliveryState) {
	this.deliveryState = deliveryState;
}

public String getDeliveryZip() {
	return deliveryZip;
}

public void setDeliveryZip(String deliveryZip) {
	this.deliveryZip = deliveryZip;
}

public String getCcNumber() {
	return ccNumber;
}

public void setCcNumber(String ccNumber) {
	this.ccNumber = ccNumber;
}

public String getCcExpiration() {
	return ccExpiration;
}

public void setCcExpiration(String ccExpiration) {
	this.ccExpiration = ccExpiration;
}

public String getCcCVV() {
	return ccCVV;
}

public void setCcCVV(String ccCVV) {
	this.ccCVV = ccCVV;
}

public List<Cuisine> getCuisines() {
	return cuisines;
}

public void setCuisines(List<Cuisine> cuisines) {
	this.cuisines = cuisines;
}
}