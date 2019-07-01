package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mechanics.GuiFacade;

public class UserPanel extends BasePanel{
	JButton add_recipe_button = new JButton("Dodaj");
	JButton accept_recipe_button = new JButton("+");
	JButton add_comment = new JButton("Dodaj_komentarz");
	JButton sing_out_button = new JButton("Wyloguj");
	
	public UserPanel(GuiFacade fac) {
		super(fac);
		
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
				// Do zrobienia:
				//fasada.dodajPrzepis()
				
				
				/*
				 * Stary kod
				recipe_area.setText("");
				ingredients_area.setText("");
				accept_recipe_button.setVisible(true);
				*/
			} 
		});	
		
	    accept_recipe_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{
				// Do zrobienia:
				// fasada.???
				
				
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
				// Do zrobienia:
				// fasada.wyloguj()
				
				/*
				 * Stary kod
				 * setLogged_helper(false);
				 */	
			} 
		});
	}
}
