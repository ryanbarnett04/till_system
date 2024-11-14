package till_system;

public class Add_ons {
	
	private String name;
	private float price;
	private String type;
	
	
	public Add_ons(String name, float price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public float getPrice() {
		return price;
	}


	public String getType() {
		return type;
	}


}
