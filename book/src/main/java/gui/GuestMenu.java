package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GuestMenu extends BaseMenu{
	
JButton loggin_button = new JButton("Zaloguj się");
JTextField login_text = new JTextField();
	
	public GuestMenu(Rectangle dimensions)
	{
		main_frame.setBounds(dimensions);
		loggin_button.setBounds(900, 20, 150, 50);
		loggin_button.setBackground(Color.LIGHT_GRAY);
		loggin_button.setVisible(true);
		p.add(loggin_button);

		login_text.setBounds(750, 20, 140, 40);
		login_text.setBackground(Color.LIGHT_GRAY);
		login_text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
		login_text.setText("Podaj nick...");
		login_text.setVisible(true);
		p.add(login_text);
		
		login_text.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				login_text.setText("");
			}	
		});
		
		loggin_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 				//akcja po zalogowaniu
				if(login_text.getText().isEmpty() != true) 
				{
					setLogged_helper(true);
					String nick = login_text.getText();
					System.out.println(nick); //to bedzie przekazane jako nick
					
				}
				
			} 
		});
		
	}
	
	public void extraThings() 
	{
		loggin_button.setVisible(true);
		login_text.setVisible(true);
		if(isLogged_helper() == true)
		{
			loggin_button.setVisible(false);
			set_logged(true);
			login_text.setVisible(false);
		}
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
	}

}
