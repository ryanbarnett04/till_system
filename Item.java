package till_system;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Item {
	
	DecimalFormat df = new DecimalFormat("0.00");
	protected String name;
	protected double itemPrice;
	protected String type;
	protected ArrayList<Add_ons> add_ons = new ArrayList<Add_ons>();
	
	public Item() {
		
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
	
	public void printAddOns() {
		for (Add_ons ao : add_ons) {
			System.out.println(" - " + ao.getName() + " £" + df.format(ao.getItemPrice()));
		}
	}
	
	public void addAddOn(Add_ons add_on) {
		add_ons.add(add_on);
	}

}
