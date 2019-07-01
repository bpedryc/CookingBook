package gui;

import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import mechanics.GuiFacade;

public class MainWindow extends JFrame {
	GuiFacade facade;
	
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
		
		this.getContentPane().add(new GuestPanel(fac));
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setBounds(dims);
		this.setVisible(true);
	}
}
