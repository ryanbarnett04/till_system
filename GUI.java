package till_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

public class GUI implements ActionListener {

	// Create useful variables
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Order currentOrder;
    private String location = "";
    private JPanel currentPanel;
    private String currentPanelName = "";
    private Item recentItem;
    private ArrayList<JButton> drinkButtons = new ArrayList<JButton>(); // Type 0
    private ArrayList<JButton> foodButtons = new ArrayList<JButton>(); // Type 1
    private ArrayList<JButton> addonsButtons = new ArrayList<JButton>(); // Type 2
    private ArrayList<JButton> navigationButtons = new ArrayList<JButton>(); // Type 3
    private ArrayList<JButton> functionButtons = new ArrayList<JButton>(); // Type 4
    
    
    // Create frame and panels
    private JFrame frame;
    private JPanel homescreen;
    private JPanel hot_drinks;
    private JPanel iced_drinks;
    private JPanel food;
    
    // Homescreen Buttons
    private JButton sit_in_button;
    private JButton take_away_button;
    private JButton receipts_button;
    
    // Order screen top band buttons
    private JButton change_location_button;
    private JButton change_panel_drinks;
    private JButton change_panel_food;
    
    // Drinks screen tab buttons
    private JButton change_panel_hot_drinks;
    private JButton change_panel_iced_drinks;
    
    // Drinks screen bottom band buttons
    private JButton decaf;
    private JButton extra_shot;
    private JButton reuse_cup;
    private JButton choc_dust;
    private JButton caramel;
    private JButton caramelSF;
    private JButton vanilla;
    private JButton vanillaSF;
    private JButton hazelnut;
    private JButton hazelnutSF;
    private JButton cinnamon_bun;
    private JButton cinnamon_bun_SF;
    
    // Hot drinks buttons
    private JButton americano_blackSML;
    private JButton americano_blackMED;
    private JButton americano_blackLRG;
    private JButton americano_whiteSML;
    private JButton americano_whiteMED;
    private JButton americano_whiteLRG;
    private JButton latteSML;
    private JButton latteMED;
    private JButton latteLRG;
    private JButton cappuccinoSML;
    private JButton cappuccinoMED;
    private JButton cappuccinoLRG;
    private JButton mochaSML;
    private JButton mochaMED;
    private JButton mochaLRG;
    private JButton flat_whiteSML;
    private JButton flat_blackSML;
    
    // Iced Drinks buttons
    private JButton iced_americanoSML;
    private JButton iced_americanoMED;
    private JButton iced_americanoLRG;
    private JButton iced_latteSML;
    private JButton iced_latteMED;
    private JButton iced_latteLRG;
    private JButton iced_cappuccinoSML;
    private JButton iced_cappuccinoMED;
    private JButton iced_cappuccinoLRG;
    private JButton iced_mochaSML;
    private JButton iced_mochaMED;
    private JButton iced_mochaLRG;
    private JButton iced_flat_whiteSML;
        
    // Food buttons - unfinished
    private JButton toast;
    
    // Create card layout
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GUI() {

    	// Instantiate frame and card layout
        frame = new JFrame("Till System");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(128, 0, 0));
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Instantiate panels
        homescreen = createPanel(128, 0, 0);      
        hot_drinks = createPanel(128, 0, 0);    
        iced_drinks = createPanel(128, 0, 0);
        food = createPanel(128, 0, 0);
        
        // Instantiate homescreen buttons
        sit_in_button = createButton("Sit-In", (screenSize.width / 2) - 225, (screenSize.height / 2) - 230, 450, 140, this, "Navigation");
        take_away_button = createButton("Take Away", (screenSize.width / 2) - 225, (screenSize.height / 2) - 70, 450, 140, this, "Navigation");
        receipts_button = createButton("Receipts", (screenSize.width / 2) - 225, (screenSize.height / 2) + 90, 450, 140, this, "Navigation");

        // Instantiate order screen top band buttons
        change_location_button = createButton("", 20, 20, 90, 90, this, "Function");
        change_panel_drinks = createButton("Drinks", 120, 20, 90, 90, this, "Navigation");
        change_panel_food = createButton("Food", 220, 20, 90, 90, this, "Navigation");
        
        // Instantiate drinks screen tab buttons
        change_panel_hot_drinks = createButton("Hot Drinks", 20, 160, 170, 90, this, "Navigation");
        change_panel_iced_drinks = createButton("Iced Drinks", 20, 270, 170, 90, this, "Navigation");
        
        // Instantiate drinks bottom band buttons
        decaf = createButton("Decaf", 265, 750, 140, 30, this, "Addon");
        extra_shot = createButton("MI Shot", 400, 750, 140, 30, this, "Addon");
        reuse_cup = createButton("Reuse", 535, 750, 140, 30, this, "Addon");
        choc_dust = createButton("Choc Dust", 670, 750, 140, 30, this, "Addon");
        caramel = createButton("Caramel", 265, 775, 140, 30, this, "Addon");
        caramelSF = createButton("Caramel SF", 400, 775, 140, 30, this, "Addon");
        vanilla = createButton("Vanilla", 535, 775, 140, 30, this, "Addon");
        vanillaSF = createButton("Caramel SF", 670, 775, 140, 30, this, "Addon");
        hazelnut = createButton("Hazelnut", 265, 800, 140, 30, this, "Addon");
        hazelnutSF = createButton("Hazelnut SF", 400, 800, 140, 30, this, "Addon");
        cinnamon_bun = createButton("Cinnamon Bun", 535, 800, 140, 30, this, "Addon");
        cinnamon_bun_SF = createButton("Cinnamon Bun SF", 670, 800, 140, 30, this, "Addon");      
        
        // Instantiate hot drinks buttons
        americano_blackSML = createButton("Americano SML", 265, 160, 170, 50, this, "Drink");
        americano_blackMED = createButton("Americano MED", 455, 160, 170, 50, this, "Drink");
        americano_blackLRG = createButton("Americano LRG", 645, 160, 170, 50, this, "Drink");

        americano_whiteSML = createButton("Americano & Milk SML", 265, 230, 170, 50, this, "Drink");
        americano_whiteMED = createButton("Americano & Milk MED", 455, 230, 170, 50, this, "Drink");
        americano_whiteLRG = createButton("Americano & Milk LRG", 645, 230, 170, 50, this, "Drink");

        latteSML = createButton("Latte SML", 265, 300, 170, 50, this, "Drink");
        latteMED = createButton("Latte MED", 455, 300, 170, 50, this, "Drink");
        latteLRG = createButton("Latte LRG", 645, 300, 170, 50, this, "Drink");

        cappuccinoSML = createButton("Cappuccino SML", 265, 370, 170, 50, this, "Drink");
        cappuccinoMED = createButton("Cappuccino MED", 455, 370, 170, 50, this, "Drink");
        cappuccinoLRG = createButton("Cappuccino LRG", 645, 370, 170, 50, this, "Drink");

        mochaSML = createButton("Mocha SML", 265, 440, 170, 50, this, "Drink");
        mochaMED = createButton("Mocha MED", 455, 440, 170, 50, this, "Drink");
        mochaLRG = createButton("Mocha LRG", 645, 440, 170, 50, this, "Drink");

        flat_whiteSML = createButton("Flat White SML", 265, 510, 270, 50, this, "Drink");
        flat_blackSML = createButton("Flat Black SML", 545, 510, 270, 50, this, "Drink");

        
        // Instantiate iced drinks buttons
        iced_americanoSML = createButton("Iced Americano SML", 265, 160, 170, 50, this, "Drink");
        iced_americanoMED = createButton("Iced Americano MED", 455, 160, 170, 50, this, "Drink");
        iced_americanoLRG = createButton("Iced Americano LRG", 645, 160, 170, 50, this, "Drink");

        iced_latteSML = createButton("Iced Latte SML", 265, 230, 170, 50, this, "Drink");
        iced_latteMED = createButton("Iced Latte MED", 455, 230, 170, 50, this, "Drink");
        iced_latteLRG = createButton("Iced Latte LRG", 645, 230, 170, 50, this, "Drink");

        iced_cappuccinoSML = createButton("Iced Cappuccino SML", 265, 300, 170, 50, this, "Drink");
        iced_cappuccinoMED = createButton("Iced Cappuccino MED", 455, 300, 170, 50, this, "Drink");
        iced_cappuccinoLRG = createButton("Iced Cappuccino LRG", 645, 300, 170, 50, this, "Drink");

        iced_mochaSML = createButton("Iced Mocha SML", 265, 370, 170, 50, this, "Drink");
        iced_mochaMED = createButton("Iced Mocha MED", 455, 370, 170, 50, this, "Drink");
        iced_mochaLRG = createButton("Iced Mocha LRG", 645, 370, 170, 50, this, "Drink");
        
        iced_flat_whiteSML = createButton("Iced Flat White SML", 265, 440, 170, 45, this, "Drink");
        
        // Instantiate food
        toast = createButton("Toast", 220, 120, 100, 80, this, "Food");

        // Non Shared Buttons
        homescreen.add(sit_in_button);
        homescreen.add(take_away_button);
        homescreen.add(receipts_button);
                
        cardPanel.add(homescreen, "Home");
        cardPanel.add(hot_drinks, "Hot Drinks");
        cardPanel.add(iced_drinks, "Iced Drinks");
        cardPanel.add(food, "Food");

        frame.add(cardPanel);
        cardLayout.show(cardPanel, "Home");
        frame.setVisible(true);
        currentPanel = homescreen;
        currentPanelName = "Home";
    }

    @Override // Button event handlers
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == change_location_button) {

            if (location.equals("IN")) {
                location = "OUT";
                change_location_button.setText("Go to EI");
            } else {
                location = "IN";
                change_location_button.setText("Go to TA");
            }

            currentPanel.add(change_location_button);
            cardLayout.show(cardPanel, currentPanelName);
        }
        
        if (e.getSource() == sit_in_button) {
            location = "IN";
            currentPanel = hot_drinks;
            currentPanelName = "Hot Drinks";
            create_hot_drinks_panel();
            String l = "";            
            if (location.equals("IN")) {
            	l = "Sit-In";
            } else {
            	l = "Takeaway";
            }            
            currentOrder = new Order(l);           
        }
        
        if (e.getSource() == take_away_button) {
        	location = "OUT";
            currentPanel = hot_drinks;
            currentPanelName = "Hot Drinks";
            create_hot_drinks_panel();
            String l = "";            
            if (location.equals("OUT")) {
            	l = "Takeaway";
            } else {
            	l = "Sit-In";
            }            
            currentOrder = new Order(l);
        }
        
        if (e.getSource() == change_panel_drinks && !currentPanelName.equals("Hot Drinks")) {
            currentPanel = hot_drinks;
            currentPanelName = "Hot Drinks";
            create_hot_drinks_panel();
        }
        
        if (e.getSource() == change_panel_food && !currentPanelName.equals("Food")) {
            currentPanel = food;
            currentPanelName = "Food";
            create_food_panel();
        }
        
        if (e.getSource() == change_panel_hot_drinks && !currentPanelName.equals("Hot Drinks")) {
            currentPanel = hot_drinks;
            currentPanelName = "Hot Drinks";
            create_hot_drinks_panel();
        }
        
        if (e.getSource() == change_panel_iced_drinks && !currentPanelName.equals("Iced Drinks")) {
            currentPanel = iced_drinks;
            currentPanelName = "Iced Drinks";
            create_iced_drinks_panel();
        }
        
        if (e.getSource() == americano_blackSML) {
        	addToOrder(americano_blackSML, "Americano", 3.60, "SML", null, null);
        }
        
        if (e.getSource() == americano_blackMED) {
        	addToOrder(americano_blackSML, "Americano", 3.80, "MED", null, null);
        }
        
        if (e.getSource() == americano_blackLRG) {
        	addToOrder(americano_blackLRG, "Americano", 4.00, "LRG", null, null);
        }
        
        if (e.getSource() == americano_whiteSML) {
        	addToOrder(americano_whiteSML, "Americano & Milk", 3.80, "SML", null, null);
        }
        
        if (e.getSource() == americano_whiteMED) {
        	addToOrder(americano_whiteMED, "Americano & Milk", 4.00, "MED", null, null);
        }
        
        if (e.getSource() == americano_whiteLRG) {
        	addToOrder(americano_whiteLRG, "Americano & Milk", 4.20, "LRG", null, null);
        }
        
        if (e.getSource() == latteSML) {
        	addToOrder(latteSML, "Latte", 3.80, "SML", null, null);
        }
        
        if (e.getSource() == latteMED) {
        	addToOrder(latteMED, "Latte", 4.00, "MED", null, null);
        }
        
        if (e.getSource() == latteLRG) {
        	addToOrder(latteLRG, "Latte", 4.20, "LRG", null, null);
        }
        
        if (e.getSource() == cappuccinoSML) {
        	addToOrder(cappuccinoSML, "Cappuccino", 3.80, "SML", null, null);
        }
        
        if (e.getSource() == cappuccinoMED) {
        	addToOrder(cappuccinoMED, "Cappuccino", 4.00, "MED", null, null);
        }
        
        if (e.getSource() == cappuccinoLRG) {
        	addToOrder(cappuccinoLRG, "Cappuccino", 4.20, "LRG", null, null);
        }
        
        if (e.getSource() == mochaSML) {
        	addToOrder(mochaSML, "Mocha", 3.80, "SML", null, null);
        }
        
        if (e.getSource() == mochaMED) {
        	addToOrder(mochaMED, "Mocha", 4.00, "MED", null, null);
        }
        
        if (e.getSource() == mochaLRG) {
        	addToOrder(mochaLRG, "Mocha", 4.20, "LRG", null, null);
        }
        
        if (e.getSource() == flat_whiteSML) {
        	addToOrder(flat_whiteSML, "Flat White", 3.60, "SML", null, null);
        }
        
        if (e.getSource() == flat_blackSML) {
        	addToOrder(flat_blackSML, "Flat Black", 3.40, "SML", null, null);
        }
        
        if (e.getSource() == toast) {
        	addToOrder(toast, "Toast", 2.40, null, null, null);
        }
        
        if (e.getSource() == caramel) {
        	addToOrder(caramel, "Caramel", 0.60, null, "Drink", "NOT_IND");
        }
        
        if (e.getSource() == caramelSF) {
        	addToOrder(caramelSF, "Caramel SF", 0.60, null, "Drink", "IND");
        }
    }
             
    // Panel rendering methods    
    public void create_top_bar(JPanel panel) {
    	panel.add(change_location_button);
    	panel.add(change_panel_drinks);
    	panel.add(change_panel_food);
    	panel.add(change_panel_hot_drinks);
    	panel.add(change_panel_iced_drinks);
    	
    	if (location.equals("IN")) {
    		change_location_button.setText("Go to TA");
    	} else {
    		change_location_button.setText("Go to EI");
    	}
    }
    
    public void create_drinks_tabs(JPanel panel) {
    	panel.add(change_panel_hot_drinks);
    	panel.add(change_panel_iced_drinks);
    }
    
    public void create_drinks_bottom_bar(JPanel panel) {
    	panel.add(decaf);
    	panel.add(extra_shot);
    	panel.add(reuse_cup);
    	panel.add(choc_dust);
    	panel.add(caramel);
    	panel.add(caramelSF);
    	panel.add(vanilla);
    	panel.add(vanillaSF);
    	panel.add(hazelnut);
    	panel.add(hazelnutSF);
    	panel.add(cinnamon_bun);
    	panel.add(cinnamon_bun_SF);
    }
            
    public void create_hot_drinks_panel() {
    	create_top_bar(hot_drinks);
    	create_drinks_tabs(hot_drinks);
    	create_drinks_bottom_bar(hot_drinks);
    	hot_drinks.add(americano_blackSML);
    	hot_drinks.add(americano_blackMED);
    	hot_drinks.add(americano_blackLRG);
    	hot_drinks.add(americano_whiteSML);
    	hot_drinks.add(americano_whiteMED);
    	hot_drinks.add(americano_whiteLRG);
    	hot_drinks.add(latteSML);
    	hot_drinks.add(latteMED);
    	hot_drinks.add(latteLRG);
    	hot_drinks.add(cappuccinoSML);
    	hot_drinks.add(cappuccinoMED);
    	hot_drinks.add(cappuccinoLRG);
    	hot_drinks.add(mochaSML);
    	hot_drinks.add(mochaMED);
    	hot_drinks.add(mochaLRG);
    	hot_drinks.add(flat_whiteSML);
    	hot_drinks.add(flat_blackSML);
    	cardLayout.show(cardPanel, "Hot Drinks");
    }
    
    public void create_iced_drinks_panel() {
    	create_top_bar(iced_drinks);
    	create_drinks_tabs(iced_drinks);
    	create_drinks_bottom_bar(iced_drinks);
    	iced_drinks.add(iced_americanoSML);
    	iced_drinks.add(iced_americanoMED);
    	iced_drinks.add(iced_americanoLRG);
    	iced_drinks.add(iced_latteSML);
    	iced_drinks.add(iced_latteMED);
    	iced_drinks.add(iced_latteLRG);
    	iced_drinks.add(iced_cappuccinoSML);
    	iced_drinks.add(iced_cappuccinoMED);
    	iced_drinks.add(iced_cappuccinoLRG);
    	iced_drinks.add(iced_mochaSML);
    	iced_drinks.add(iced_mochaMED);
    	iced_drinks.add(iced_mochaLRG);
    	iced_drinks.add(iced_flat_whiteSML);
    	cardLayout.show(cardPanel, "Iced Drinks");
    }
    
    public void create_food_panel() {
    	food.add(change_location_button);
    	change_location_button.setText(location);
    	food.add(change_panel_drinks);
    	food.add(change_panel_food);
    	food.add(toast);
    	
    	if (location.equals("IN")) {
    		change_location_button.setText("Go to TA");
    	} else {
    		change_location_button.setText("Go to EI");
    	}
    	cardLayout.show(cardPanel, "Food");
    }
    
    // Create panel method
    public JPanel createPanel(int r, int g, int b) {
    	JPanel jp = new JPanel();
    	jp.setLayout(null);
    	jp.setBackground(new Color(r, g, b));
    	return jp;
    }
    
    // Create button method
    public JButton createButton(String buttonText, int x, int y, int width, int height, ActionListener al, String buttonType) {
    	JButton jb = new JButton(buttonText);
    	jb.setBounds(x, y, width, height);
    	jb.addActionListener(al);
    	switch(buttonType) {
    	case "Drink":
    		addButtonToList(jb, getDrinksButtons());
    		break;
    	case "Food":
    		addButtonToList(jb, getFoodButtons());
    		break;
    	case "Addon":
    		addButtonToList(jb, getAddonsButtons());
    		break;
    	case "Navigation":
    		addButtonToList(jb, getNavigationButtons());
    		break;
    	case "Function":
    		addButtonToList(jb, getFunctionButtons());
    		break;
    	}
    	return jb;
    }
    
    // Add button to list
    public void addButtonToList(JButton button, ArrayList<JButton> ar) {
		ar.add(button);
	}
    
    // Add item to order
    public void addToOrder(JButton button, String name, double price, String size, String addonType, String addonInd) {
    	boolean valid = true;
    	Item item = null;
    	
    	if (drinkButtons.contains(button)) {
    		item = new Drink(name, price, size);
    		currentOrder.addItem((Drink)item);
    		recentItem = (Drink)item;
    	}
    	else if (foodButtons.contains(button)) {
    		item = new Food(name, price);
    		currentOrder.addItem((Food)item);
    		recentItem = (Food)item;
    	} else if (addonsButtons.contains(button)) {
    		item = new Add_ons(name, price, addonType, addonInd);
    		if (addonInd.equals("IND")) {
    			currentOrder.addItem((Add_ons)item);
        		recentItem = (Add_ons)item;
    		} else {
    			if (recentItem != null && (recentItem instanceof Drink || recentItem instanceof Food)) {
    				recentItem.addAddOn((Add_ons)item);
    			} else {
    				valid = false;
    			}
    		}
    	}
    	
    	if (valid) {
    		currentOrder.setOrderPrice(currentOrder.getOrderPrice() + price);
    	}
    	currentOrder.printOrder();
    }
    
    // Getters for button lists
    public ArrayList<JButton> getDrinksButtons() {
    	return this.drinkButtons;
    }
    
    public ArrayList<JButton> getFoodButtons() {
    	return this.foodButtons;
    }
    
    public ArrayList<JButton> getAddonsButtons() {
    	return this.addonsButtons;
    }
    
    public ArrayList<JButton> getNavigationButtons() {
    	return this.navigationButtons;
    }
    
    public ArrayList<JButton> getFunctionButtons() {
    	return this.functionButtons;
    }
    
}