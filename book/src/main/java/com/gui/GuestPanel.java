package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import mechanics.GuiFacade;

public class GuestPanel extends BasePanel {

	JButton login_button = new JButton("Zaloguj się");
	JTextField login_text = new JTextField();
	
	public GuestPanel(MainWindow win, GuiFacade fac) {
		super(win, fac);
		
		login_button.setBounds(900, 20, 150, 50);
		login_button.setBackground(Color.LIGHT_GRAY);
		login_button.setVisible(true);	
		this.add(login_button);
		
		login_text.setBounds(750, 20, 140, 40);
		login_text.setBackground(Color.LIGHT_GRAY);
		login_text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
		login_text.setText("Podaj nick...");
		login_text.setVisible(true);
		this.add(login_text);
		
		login_text.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				login_text.setText("");
			}	
		});
		
		login_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 	
				String test = login_text.getText();
				if (facade.logIn(login_text.getText())) {
					window.displayPanel(window.getUserPanel());
				} 
				/*
				 * Stary kod
				//akcja po zalogowaniu
				if(login_text.getText().isEmpty() != true) 
				{
					setLogged_helper(true);
					String nick = login_text.getText();
					System.out.println(nick); //to bedzie przekazane jako nick
					
				}
				*/
				
			} 
		});
	}
	
}
