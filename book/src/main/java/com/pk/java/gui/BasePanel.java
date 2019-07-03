package com.pk.java.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.pk.java.mechanics.GuiFacade;

public abstract class BasePanel extends JPanel {
	
	MainWindow window;
	GuiFacade facade;
	
	JButton next_page_button = new JButton(">>");
	JButton previous_page_button = new JButton("<<");
	JButton search_button = new JButton("Szukaj");
	JButton table_of_contents_button = new JButton("Spis treści");

	String[] filter_table = {"Składniki", "Nazwa przepisu", "Autor"};
	JComboBox<String> filter_list = new JComboBox<String>(filter_table);
	
	JTextArea recipe_area = new JTextArea();
	JScrollPane recipe_scroll = new JScrollPane(recipe_area);
	JTextArea ingredients_area = new JTextArea("Lista przepisow tu bedzie");	
	JScrollPane ingredients_scroll = new JScrollPane(ingredients_area);
	JTextArea page_search_area = new JTextArea();
	JTextArea search_page_area = new JTextArea("Przejdź do str");
	
	JTextField search_text = new JTextField();

	int counter = 0;
	String[] recipe_raw = new String[4];

	public BasePanel(MainWindow win, GuiFacade fac) {
		this.window = win;
		this.facade = fac;
		
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		
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
		recipe_area.setLineWrap(true);
		recipe_area.setWrapStyleWord(true);
		this.add(recipe_scroll);
		
		ingredients_scroll.setBounds(20, 100, 300, 400);
		ingredients_area.setBackground(Color.LIGHT_GRAY);
		ingredients_area.setFont(new Font("Serif", Font.ITALIC, 16));
		ingredients_area.setText(recipe_raw[1]);
		ingredients_area.setEditable(false);
		ingredients_area.setLineWrap(true);
		ingredients_area.setWrapStyleWord(true);
		this.add(ingredients_scroll);
		
		search_text.setBounds(150, 20, 500, 40);
		search_text.setBackground(Color.LIGHT_GRAY);
		search_text.setFont(new Font("Serif", Font.ROMAN_BASELINE, 16));
		search_text.setText("Wpisz szukaną frazę...");
		this.add(search_text);
		
		page_search_area.setBounds(180, 690, 140, 50);
		page_search_area.setBackground(Color.LIGHT_GRAY);
		page_search_area.setFont(new Font("Serif", Font.ROMAN_BASELINE, 32));
		page_search_area.setText("");
		this.add(page_search_area);
		
		search_page_area.setBounds(20, 690, 150, 50);
		search_page_area.setForeground(Color.LIGHT_GRAY);
		search_page_area.setBackground(Color.DARK_GRAY);
		search_page_area.setFont(new Font("Serif", Font.ROMAN_BASELINE, 26));
		
		table_of_contents_button.setBounds(20, 570, 110, 50);
		table_of_contents_button.setBackground(Color.LIGHT_GRAY);
		this.add(table_of_contents_button);
		
		this.add(search_page_area);
		
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
				
			} 
		});	
		
        previous_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				String[] recipe_raw = facade.getPrevRecipe();
				recipe_area.setText(recipe_raw[0]);
				ingredients_area.setText(recipe_raw[1]);
				
			} 
		});	
        
        search_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				HashMap<Integer, String> found_titles = facade.search(search_text.getText());
				// wyświetlaj wszystkie te w postaci spisu tresci
					//titles_buttons.add(new JButton(found_titles.get(i)));
				//int i = 0;
				ingredients_area.setText("");
				recipe_area.setText("");
				String seach_results = new String();
				for (Object key : found_titles.keySet()) 
				{
					seach_results += (found_titles.get(key).toString() + "   str ");
					seach_results += (key + "\n");
					
				}				
				//add_search_buttons(titles_search_buttons);
				recipe_area.setText(seach_results);
			}

			
		});	
        
        filter_list.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				facade.setSearchingType(filter_list.getSelectedItem().toString());
			} 
		});
        
        
        page_search_area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                	int choosen_page = -1;
                		try {
                        	choosen_page = Integer.parseInt(page_search_area.getText().trim());

                	    } catch (NumberFormatException | NullPointerException nfe) {
                	    }          
            			String[] recipe_raw = facade.getChosenRecipe(choosen_page);

    	                recipe_area.setText(recipe_raw[0]);
    	    			ingredients_area.setText(recipe_raw[1]);
                    	page_search_area.setCaretPosition(0);
                    	page_search_area.setText("");
                	}
       
            }
        });
        
        table_of_contents_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				String table_of_contents = facade.tableOfContents();
				recipe_area.setText(table_of_contents);	
				ingredients_area.setText("");
			} 
		});	
	}

}
