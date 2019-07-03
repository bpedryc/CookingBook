package com.pk.java.gui;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.pk.java.mechanics.GuiFacade;

public class MainWindow extends JFrame {
	GuiFacade facade;
	
	GuestPanel guest_panel;
	UserPanel user_panel;
	
	public MainWindow(Rectangle dims, GuiFacade fac) {
		super("Cooking Book");
		
		this.addWindowListener(new WindowAdapter () {
			@Override
			public void windowClosing(WindowEvent e) {
				facade.saveRecipes();
				System.exit(0);
			}
		});
		
		this.facade = fac; 
		guest_panel = new GuestPanel(this, fac);
		user_panel = new UserPanel(this, fac);
		
		this.displayPanel(guest_panel);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(dims);
		this.setVisible(true);
	}
	
	public GuestPanel getGuestPanel() {
		return this.guest_panel;
	}
	
	public UserPanel getUserPanel() {
		return this.user_panel;
	}
	
	public void displayPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
}
