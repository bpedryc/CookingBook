package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mechanics.GuiFacade;

public class BasePanel extends JPanel {
	
	GuiFacade facade;
	
	JButton next_page_button = new JButton(">>");
	JButton previous_page_button = new JButton("<<");
	JButton search_button = new JButton("Szukaj");
	
	String[] filter_table = {"Składniki", "Nazwa przepisu", "Autor"};
	JComboBox<String> filter_list = new JComboBox<String>(filter_table);
	
	JTextArea recipe_area = new JTextArea();
	JScrollPane recipe_scroll = new JScrollPane(recipe_area);
	JTextArea ingredients_area = new JTextArea("Lista przepisow tu bedzie");	
	JScrollPane ingredients_scroll = new JScrollPane(ingredients_area);
	
	JTextField search_text = new JTextField();
	
	int counter = 0;
	String[] recipe_raw = new String[4];
	
	public BasePanel(GuiFacade fac) {
		this.facade = fac;
		
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		
		/* sposob na przyciski bez tla i ramek (tak jak link w htmlu)
		next_page_button.setBorder(null);
		next_page_button.setOpaque(false);
		next_page_button.setContentAreaFilled(false);
		next_page_button.setBorderPainted(false);
		*/
		
		next_page_button.setBounds(80, 510, 50, 50);
		next_page_button.setBackground(Color.LIGHT_GRAY);
		this.add(next_page_button);
		
		previous_page_button.setBounds(20, 510, 50, 50);
		previous_page_button.setBackground(Color.LIGHT_GRAY);
		this.add(previous_page_button);
		
		search_button.setBounds(660, 20, 80, 40);
		search_button.setBackground(Color.LIGHT_GRAY);
		this.add(search_button);
		
		filter_list.setBounds(20, 20, 120, 40);
		filter_list.setBackground(Color.LIGHT_GRAY);
		this.add(filter_list);
		
		recipe_scroll.setBounds(400, 100, 600, 670);
		recipe_area.setBackground(Color.LIGHT_GRAY);
		recipe_area.setFont(new Font("Serif", Font.ITALIC, 16));
		this.add(recipe_scroll);
		
		ingredients_scroll.setBounds(20, 100, 300, 400);
		ingredients_area.setBackground(Color.LIGHT_GRAY);
		ingredients_area.setFont(new Font("Serif", Font.ITALIC, 16));
		this.add(ingredients_scroll);
		
		search_text.setBounds(150, 20, 500, 40);
		search_text.setBackground(Color.LIGHT_GRAY);
		search_text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
		search_text.setText("Wpisz szukaną frazę...");
		this.add(search_text);
		
		search_text.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    search_text.setText("");
			}	
		});
		
		next_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				if(counter == 0)
				{
					counter = 1;
					recipe_area.setText(recipe_raw[counter + 1]);
					ingredients_area.setText(recipe_raw[counter + 2]);
				}
				else
				{
					counter = 0;
					recipe_area.setText(recipe_raw[counter]);
					ingredients_area.setText(recipe_raw[counter + 1]);
				}
			} 
		});	
		
        previous_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				if(counter == 0)
				{
					counter = 1;
					recipe_area.setText(recipe_raw[counter + 1]);
					ingredients_area.setText(recipe_raw[counter + 2]);
				}
				else
				{
					counter = 0;
					recipe_area.setText(recipe_raw[counter]);
					ingredients_area.setText(recipe_raw[counter + 1]);
				}
			} 
		});	
        
        search_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				System.out.println(search_text.getText()); //to czego szukamy	
			} 
		});	
        
        filter_list.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				System.out.println(filter_list.getSelectedItem()); //to po czym szukamy
			} 
		});
	}
}
