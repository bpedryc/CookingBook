package com.ksiazka_kucharska.kucharska_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Guest_user extends MainFrame{
	
JButton loggin_button = new JButton("Zaloguj się");
	
	public Guest_user()
	{
		loggin_button.setBounds(850, 20, 150, 50);
		loggin_button.setBackground(Color.LIGHT_GRAY);
		loggin_button.setVisible(false);
		p.add(loggin_button);
		
		
	}
	
	public void extra_things() 
	{
		loggin_button.setVisible(true);
		loggin_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				//akcja po zalogowaniu
				loggin_button.setVisible(false);
				set_logged(true);
				
			} 
		});	
	}

}
