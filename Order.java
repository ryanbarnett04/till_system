package till_system;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {
	
	DecimalFormat df = new DecimalFormat("0.00");
	private String location;
	private double totalPrice;
	private ArrayList<Item> orderList;
	
	public Order() {
		
	}
	
	public Order(String location) {
		this.location = location;
		this.totalPrice = 0.0;
		this.orderList = new ArrayList<Item>();
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
	
	public ArrayList<Item> getOrderList() {
		return this.orderList;
	}
	
	public void addItem(Item item) {
		orderList.add(item);
	}
	
	public void removeItem(int index) {
		orderList.remove(index);
	}
	
	public ArrayList<Add_ons> getItemAddOns(int index) {

	    if (index < 0 || index >= orderList.size()) {
	        return null;
	    }

	    Item item = orderList.get(index);

	    if (item instanceof Food || item instanceof Drink) {
	        return (item.getAdd_ons());
	    } else {
	        return null;
	    }
	}
	
	public void printOrder() {
		System.out.println("Order:");
		for (Item i : orderList) {
			if (i instanceof Drink) {
				Drink d = (Drink) i;
				System.out.println(d.getSize() + " " + d.getName() + " £" + df.format(d.getItemPrice()));
				d.printAddOns();
			} else if (i instanceof Food) {
				Food f = (Food) i;
				System.out.println(f.getName() + " £" + df.format(f.getItemPrice()));
				f.printAddOns();
			} else if (i instanceof Add_ons && ((Add_ons) i).getIndependant().equals("IND")) {
				Add_ons add = (Add_ons) i;
				System.out.println("IND: " + add.getName() + " £" + df.format(add.getItemPrice()));
			}
		}
		System.out.println("Total: £" + df.format(totalPrice) + "\n");
	}


}
