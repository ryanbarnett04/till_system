package till_system;

public class Drink extends Item {
	
	private String size;
	
	public Drink(String name, double itemPrice, String size) {
		this.name = name;
		this.itemPrice = itemPrice;
		this.size = size;
		this.type = "Drink";
	}
	
	public String getSize() {
		return size;
	}
	
}
