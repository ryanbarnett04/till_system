package till_system;

public class Add_ons {
	
	private String name;
	private double price;
	private String type;
	
	
	public Add_ons(String name, double price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public String getType() {
		return type;
	}


}
