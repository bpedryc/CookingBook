package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Caret;

import mechanics.GuiFacade;

public abstract class BasePanel extends JPanel {
	
	MainWindow window;
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
	JTextArea page_search_area = new JTextArea();
	
	JTextField search_text = new JTextField();
	
	List titles_buttons =  new List();

	int counter = 0;
	String[] recipe_raw = new String[4];
	
	public BasePanel(MainWindow win, GuiFacade fac) {
		this.window = win;
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
		
		String[] recipe_raw = facade.getChosenRecipe(0);
		
		recipe_scroll.setBounds(400, 100, 600, 670);
		recipe_area.setBackground(Color.LIGHT_GRAY);
		recipe_area.setFont(new Font("Serif", Font.ITALIC, 16));
		recipe_area.setText(recipe_raw[0]);
		recipe_area.setEditable(false);
		this.add(recipe_scroll);
		
		ingredients_scroll.setBounds(20, 100, 300, 400);
		ingredients_area.setBackground(Color.LIGHT_GRAY);
		ingredients_area.setFont(new Font("Serif", Font.ITALIC, 16));
		ingredients_area.setText(recipe_raw[1]);
		ingredients_area.setEditable(false);
		this.add(ingredients_scroll);
		
		search_text.setBounds(150, 20, 500, 40);
		search_text.setBackground(Color.LIGHT_GRAY);
		search_text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
		search_text.setText("Wpisz szukaną frazę...");
		this.add(search_text);
		
		page_search_area.setBounds(500, 780, 50, 50);
		page_search_area.setBackground(Color.LIGHT_GRAY);
		page_search_area.setFont(new Font("Serif", Font.ROMAN_BASELINE, 32));
		page_search_area.setText("");
		this.add(page_search_area);
		
		search_text.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    search_text.setText("");
			}	
		});
		
		next_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				String[] recipe_raw = facade.getNextRecipe();
				recipe_area.setText(recipe_raw[0]);
				ingredients_area.setText(recipe_raw[1]);
				
				/*
				 * Stary kod
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
				*/
			} 
		});	
		
        previous_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				String[] recipe_raw = facade.getPrevRecipe();
				recipe_area.setText(recipe_raw[0]);
				ingredients_area.setText(recipe_raw[1]);
				
				/*
				 * Stary kod
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
				*/
			} 
		});	
        
        search_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				HashMap<Integer, String> found_titles = facade.search(search_text.getText());
				// wyświetlaj wszystkie te w postaci spisu tresci
				System.out.println(found_titles);
					//titles_buttons.add(new JButton(found_titles.get(i)));
				int i = 0;
				ingredients_area.setText("");
				recipe_area.setText("");
				String seach_results = new String();
				for (Object key : found_titles.keySet()) 
				{
					seach_results += (found_titles.get(key).toString() + "   str ");
					seach_results += (key + "\n");
				}						
				recipe_area.setText(seach_results);
				/*
				 * Stary kod
				 * System.out.println(search_text.getText()); //to czego szukamy	
				 */
			}

			
		});	
        
        filter_list.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				facade.setSearchingType(filter_list.getSelectedItem().toString());
				
				
				/*
				 * Stary kod
				System.out.println(filter_list.getSelectedItem()); //to po czym szukamy
				*/
			} 
		});
        
        page_search_area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                	String choosen_page = new String();
                	choosen_page = page_search_area.getText().trim();
                	System.out.println(choosen_page);
                	page_search_area.setText("");
                	//nalezy dodac mozliwosc przechodzenia do strony po wpisaniu jej numeru
                	if(choosen_page.isEmpty() == false)
	                {	String[] recipe_raw = facade.getChosenRecipe(Integer.parseInt(choosen_page.trim()));
	                	recipe_area.setText(recipe_raw[0]);
	    				ingredients_area.setText(recipe_raw[1]);
                	}
                	page_search_area.setCaretPosition(0);

                }
            }
        });
	}
}
