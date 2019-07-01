package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mechanics.GuiFacade;

public class UserPanel extends BasePanel {
	
	JButton add_recipe_button = new JButton("Kreator");
	JButton accept_recipe_button = new JButton("+");
	JButton add_comment = new JButton("Dodaj_komentarz");
	JButton sing_out_button = new JButton("Wyloguj");
	boolean creating_recipe = false;
	
	public UserPanel(MainWindow win, GuiFacade fac) {
		super(win, fac);
		
		add_recipe_button.setBounds(140, 510, 100, 50);
		add_recipe_button.setBackground(Color.LIGHT_GRAY);
		add_recipe_button.setVisible(true);
		this.add(add_recipe_button);
		
		accept_recipe_button.setBackground(Color.LIGHT_GRAY);
		accept_recipe_button.setBounds(250, 510, 50, 50);
		accept_recipe_button.setVisible(false);
		this.add(accept_recipe_button);
		
		sing_out_button.setBackground(Color.LIGHT_GRAY);
		sing_out_button.setBounds(900, 20, 150, 50);
		sing_out_button.setVisible(true);
		this.add(sing_out_button);
				
		add_recipe_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{
				// Tutaj użytkownik rozpoczyna proces tworzenia przepisu
				// Zadanie dla Pietruchy: Uniemożliwić użytkownikowi zmienianie przpisów
				if (!creating_recipe) {
					creating_recipe = true;
					ingredients_area.setText("składnik1\nskładnik2");
					recipe_area.setText("Nazwa przepisu\nAutor\nOcena\nCzas wykonania\nOpis");
					accept_recipe_button.setVisible(true);
					next_page_button.setVisible(false);
					previous_page_button.setVisible(false);
				} else {
					creating_recipe = false;
					String[] raw_recipe = facade.getChosenRecipe(facade.getActualIt());
					recipe_area.setText(raw_recipe[0]);
					ingredients_area.setText(raw_recipe[1]);
					accept_recipe_button.setVisible(false);
					next_page_button.setVisible(true);
					previous_page_button.setVisible(true);
					accept_recipe_button.setVisible(false);
				}
			} 
		});	
		
	    accept_recipe_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{
				if(facade.createRecipe(recipe_area.getText(), ingredients_area.getText())) {
					creating_recipe = false;
					String[] raw_recipe = facade.getChosenRecipe(facade.getActualIt());
					recipe_area.setText(raw_recipe[0]);
					ingredients_area.setText(raw_recipe[1]);
					accept_recipe_button.setVisible(false);
					next_page_button.setVisible(true);
					previous_page_button.setVisible(true);
					accept_recipe_button.setVisible(false);
				}
				
				/*
				 * Stary kod
			    String recipe = recipe_area.getText();
			    String ingredients = ingredients_area.getText();
			    System.out.println(recipe);
			    System.out.println(ingredients);			     
			    accept_recipe_button.setVisible(false);
			    */	  
			} 
		});
	    
	    sing_out_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				facade.logOut();
				window.displayPanel(window.getGuestPanel());
				
				/*
				 * Stary kod
				 * setLogged_helper(false);
				 */	
			} 
		});
	}
}
