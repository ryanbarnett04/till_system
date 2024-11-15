package till_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener {

	// Create useful variables
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Order currentOrder;
    private String location = "";
    private JPanel currentPanel;
    private String currentPanelName = "";
    private Object recentItem;
    
    
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
    
    // Iced drinks buttons
    private JButton iced_latteSML;
    
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
        homescreen = new JPanel();
        homescreen.setLayout(null);
        homescreen.setBackground(new Color(128, 0, 0));
        
        hot_drinks = new JPanel();
        hot_drinks.setLayout(null);
        hot_drinks.setBackground(new Color(128, 0, 0));
        
        iced_drinks = new JPanel();
        iced_drinks.setLayout(null);
        iced_drinks.setBackground(new Color(128, 0, 0));

        food = new JPanel();
        food.setLayout(null);
        food.setBackground(new Color(128, 0, 0));
        
        // Instantiate homescreen buttons
        sit_in_button = new JButton("Sit-In");
        sit_in_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) - 230, 450, 140);
        sit_in_button.addActionListener(this);

        take_away_button = new JButton("Take Away");
        take_away_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) - 70, 450, 140);
        take_away_button.addActionListener(this);

        receipts_button = new JButton("Receipts");
        receipts_button.setBounds((screenSize.width / 2) - 225, (screenSize.height / 2) + 90, 450, 140);
        receipts_button.addActionListener(this);

        // Instantiate order screen top band buttons
        change_location_button = new JButton("");
        change_location_button.setBounds(20, 20, 90, 90);
        change_location_button.addActionListener(this);

        change_panel_drinks = new JButton("Drinks");
        change_panel_drinks.setBounds(120, 20, 90, 90);
        change_panel_drinks.addActionListener(this);

        change_panel_food = new JButton("Food");
        change_panel_food.setBounds(220, 20, 90, 90);
        change_panel_food.addActionListener(this);
        
        // Instantiate drinks screen tab buttons
        change_panel_hot_drinks = new JButton("Hot Drinks");
        change_panel_hot_drinks.setBounds(20, 160, 170, 90);
        change_panel_hot_drinks.addActionListener(this);
        
        change_panel_iced_drinks = new JButton("Iced Drinks");
        change_panel_iced_drinks.setBounds(20, 270, 170, 90);
        change_panel_iced_drinks.addActionListener(this);
        
        // Instantiate hot drinks buttons
        americano_blackSML = new JButton("Americano SML");
        americano_blackSML.setBounds(265, 160, 170, 50);
        americano_blackSML.addActionListener(this);
        
        americano_blackMED = new JButton("Americano MED");
        americano_blackMED.setBounds(455, 160, 170, 50);
        americano_blackMED.addActionListener(this);
        
        americano_blackLRG = new JButton("Americano LRG");
        americano_blackLRG.setBounds(645, 160, 170, 50);
        americano_blackLRG.addActionListener(this);
        
        americano_whiteSML = new JButton("Americano & Milk SML");
        americano_whiteSML.setBounds(265, 230, 170, 50);
        americano_whiteSML.addActionListener(this);
        
        americano_whiteMED = new JButton("Americano & Milk MED");
        americano_whiteMED.setBounds(455, 230, 170, 50);
        americano_whiteMED.addActionListener(this);
        
        americano_whiteLRG = new JButton("Americano & Milk LRG");
        americano_whiteLRG.setBounds(645, 230, 170, 50);
        americano_whiteLRG.addActionListener(this);
        
        latteSML = new JButton("Latte SML");
        latteSML.setBounds(265, 300, 170, 50);
        latteSML.addActionListener(this);
        
        latteMED = new JButton("Latte MED");
        latteMED.setBounds(455, 300, 170, 50);
        latteMED.addActionListener(this);
        
        latteLRG = new JButton("Latte LRG");
        latteLRG.setBounds(645, 300, 170, 50);
        latteLRG.addActionListener(this);
        
        cappuccinoSML = new JButton("Cappuccino SML");
        cappuccinoSML.setBounds(265, 370, 170, 50);
        cappuccinoSML.addActionListener(this);
        
        cappuccinoMED = new JButton("Cappuccino MED");
        cappuccinoMED.setBounds(455, 370, 170, 50);
        cappuccinoMED.addActionListener(this);
        
        cappuccinoLRG = new JButton("Cappuccino LRG");
        cappuccinoLRG.setBounds(645, 370, 170, 50);
        cappuccinoLRG.addActionListener(this);
        
        mochaSML = new JButton("Mocha SML");
        mochaSML.setBounds(265, 440, 170, 50);
        mochaSML.addActionListener(this);
        
        mochaMED = new JButton("Mocha MED");
        mochaMED.setBounds(455, 440, 170, 50);
        mochaMED.addActionListener(this);
        
        mochaLRG = new JButton("Mocha LRG");
        mochaLRG.setBounds(645, 440, 170, 50);
        mochaLRG.addActionListener(this);
        
        flat_whiteSML = new JButton("Flat White SML");
        flat_whiteSML.setBounds(265, 510, 270, 50);
        flat_whiteSML.addActionListener(this);
        
        flat_blackSML = new JButton("Flat Black SML");
        flat_blackSML.setBounds(545, 510, 270, 50);
        flat_blackSML.addActionListener(this);
        
        // Instantiate iced drinks buttons
        iced_latteSML = new JButton("Iced Latte SML");
        iced_latteSML.setBounds(220, 160, 120, 60);
        iced_latteSML.addActionListener(this);
        
        toast = new JButton("Toast");
        toast.setBounds(220, 120, 100, 80);
        toast.addActionListener(this);

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

    @Override
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
        	Drink d = new Drink("Americano", 3.80, "SML");
        	currentOrder.addItem(d);
        	currentOrder.setOrderPrice(currentOrder.getOrderPrice() + 3.80);
        	recentItem = d;
        	currentOrder.printOrder();
        }
        
        if (e.getSource() == americano_blackMED) {
        	Drink d = new Drink("Americano", 4.00, "MED");
        	currentOrder.addItem(d);
        	currentOrder.setOrderPrice(currentOrder.getOrderPrice() + 4.00);
        	recentItem = d;
        	currentOrder.printOrder();
        }
    }
        
    // Panel creation methods    
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
            
    public void create_hot_drinks_panel() {
    	create_top_bar(hot_drinks);
    	create_drinks_tabs(hot_drinks);
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
    	iced_drinks.add(iced_latteSML);
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
}