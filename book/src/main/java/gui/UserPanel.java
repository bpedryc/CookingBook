package gui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

public class LoggedMenu extends BaseMenu{
	
	JButton add_precipe_button = new JButton("Dodaj");
	JButton accept_precipe_button = new JButton("+");
	JButton add_comment = new JButton("Dodaj_komentarz");
	JButton sing_out_button = new JButton("Wyloguj");

	public LoggedMenu(Rectangle dimensions) 
	{
		set_logged(true);
		setLogged_helper(true);
		main_frame.setBounds(dimensions);
		
		add_precipe_button.setBounds(140, 510, 100, 50);
		add_precipe_button.setBackground(Color.LIGHT_GRAY);
		add_precipe_button.setVisible(true);
		p.add(add_precipe_button);
		
		accept_precipe_button.setBackground(Color.LIGHT_GRAY);
		accept_precipe_button.setBounds(250, 510, 50, 50);
		accept_precipe_button.setVisible(false);
		p.add(accept_precipe_button);
		
		sing_out_button.setBackground(Color.LIGHT_GRAY);
		sing_out_button.setBounds(900, 20, 150, 50);
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
			    accept_precipe_button.setVisible(false);
					  
			} 
		});
	    
	    sing_out_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				setLogged_helper(false);
				
			} 
		});
	}
	public void extraThings() 
	{
		if(isLogged_helper() == false)
		{
			sing_out_button.setVisible(false);
			add_precipe_button.setVisible(false);
			accept_precipe_button.setVisible(false);
			set_logged(false);
		}		
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}

