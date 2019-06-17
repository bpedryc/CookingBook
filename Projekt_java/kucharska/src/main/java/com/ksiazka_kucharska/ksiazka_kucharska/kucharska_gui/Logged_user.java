package com.ksiazka_kucharska.kucharska_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import javax.swing.JButton;

public class Logged_user extends MainFrame{
	
	JButton add_precipe_button = new JButton("Dodaj przepis");
	JButton accept_precipe_button = new JButton("dodaj");
	JButton add_comment = new JButton("Dodaj_komentarz");
	JButton sing_out_button = new JButton("Wyloguj");

	public Logged_user() 
	{
		add_precipe_button.setBounds(220, 20, 150, 50);
		add_precipe_button.setBackground(Color.LIGHT_GRAY);
		add_precipe_button.setVisible(true);
		p.add(add_precipe_button);
		
		accept_precipe_button.setBackground(Color.LIGHT_GRAY);
		accept_precipe_button.setBounds(390, 20, 100, 50);
		accept_precipe_button.setVisible(false);
		p.add(accept_precipe_button);
		
		sing_out_button.setBackground(Color.LIGHT_GRAY);
		sing_out_button.setBounds(850, 20, 150, 50);
		sing_out_button.setVisible(true);
		p.add(sing_out_button);
		
		add_precipe_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				precipe_area.setText("");
				ingredients_area.setText("");
				accept_precipe_button.setVisible(true);

					  
			} 
		});	
		
	    accept_precipe_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{
			    String precipe = precipe_area.getText();
			    String ingredients = ingredients_area.getText();
			    System.out.println(precipe);
			    System.out.println(ingredients);			     
			    BufferedWriter writer1 = null;
			    BufferedWriter writer2 = null;
			    accept_precipe_button.setVisible(false);
					  
			} 
		});
	}
	public void extra_things() 
	{
		add_precipe_button.setVisible(true);
		sing_out_button.setVisible(true);
		
		sing_out_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				//akcja po zalogowaniu
				sing_out_button.setVisible(false);
				add_precipe_button.setVisible(false);
				accept_precipe_button.setVisible(false);
				set_logged(false);
				
			} 
		});	
	}

}
