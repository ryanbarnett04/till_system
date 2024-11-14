package till_system;

import java.util.ArrayList;

public class Food extends Order {

	private String name;
	private double itemPrice;
	private String type;
	private ArrayList<Add_ons> add_ons = new ArrayList<Add_ons>();

	
	public Food(String name, double itemPrice) {
		this.name = name;
		this.itemPrice = itemPrice;
		this.type = "Drink";
	}


	public String getName() {
		return name;
	}


	public double getItemPrice() {
		return itemPrice;
	}
	
	public String getType() {
		return type;
	}


	public ArrayList<Add_ons> getAdd_ons() {
		return add_ons;
	}

}
