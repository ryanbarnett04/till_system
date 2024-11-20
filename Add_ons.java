package till_system;

public class Add_ons extends Item {

	private String independant;
	private String addType;
		
	public Add_ons(String name, double price, String addType, String independant) {
		this.name = name;
		this.itemPrice = price;
		this.type = "Add On";
		this.addType = addType;
		this.independant = independant;
	}
	
	public String getIndependant() {
		return independant;
	}
	
	public String getAddType() {
		return addType;
	}


}
