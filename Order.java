package till_system;

import java.util.ArrayList;

public class Order {
	
	private String location;
	private double totalPrice;
	private ArrayList<Object> orderList;
	
	public Order() {
		
	}
	
	public Order(String location) {
		this.location = location;
		this.totalPrice = 0.0;
		this.orderList = new ArrayList<Object>();
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public double getOrderPrice() {
		return this.totalPrice;
	}
	
	public void setOrderPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public ArrayList<Object> getOrderList() {
		return this.orderList;
	}
	
	public void addItem(Object item) {
		orderList.add(item);
	}
	
	public void removeItem(int index) {
		orderList.remove(index);
	}
	
	public ArrayList<Add_ons> getItemAddOns(int index) {

	    if (index < 0 || index >= orderList.size()) {
	        return null;
	    }

	    Object item = orderList.get(index);

	    if (item instanceof Food) {
	        return ((Food) item).getAdd_ons();
	    } else if (item instanceof Drink) {
	        return ((Drink) item).getAdd_ons();
	    } else {
	        return null; // Item is not of type Food or Drink
	    }
	}


}
