package com.ksiazka_kucharska.kucharska_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class MainFrame {
	static JPanel p = new JPanel();
	static JButton next_page_button = new JButton(">>");
	static JButton previous_page_button = new JButton("<<");
	static JTextArea precipe_area = new JTextArea();
	static JTextArea ingredients_area = new JTextArea("Lista przepisow tu bedzie");	
	static JScrollPane ingredients_scroll = new JScrollPane(ingredients_area);
	static JScrollPane precipe_scroll = new JScrollPane(precipe_area);
	static JFrame main_frame = new JFrame();
	int counter = 0;
	private static boolean logged = false;
	String text0 = null;
	String text1 = null;
	String text2 = null;
	String text3 = null;
	String[] precipes_and_indgredients = new String[4];
	
	public abstract void extra_things();
	
	public MainFrame()
	{
		//main_frame.super("Ksiazka kucharska");
		main_frame.setBounds(300, 100, 1100, 900);
		//setSize(1100, 900);
		main_frame.setResizable(true);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setLayout(null);
		p.setBackground(Color.DARK_GRAY);
		
		next_page_button.setBounds(120, 20, 50, 50);
		next_page_button.setBackground(Color.LIGHT_GRAY);
		p.add(next_page_button);
		
		previous_page_button.setBounds(20, 20, 50, 50);
		previous_page_button.setBackground(Color.LIGHT_GRAY);
		p.add(previous_page_button);
		
		precipe_scroll.setBounds(400, 100, 600, 700);
		precipe_area.setBackground(Color.LIGHT_GRAY);
		precipe_area.setFont(new Font("Serif", Font.ITALIC, 16));
		p.add(precipe_scroll);
		
		ingredients_scroll.setBounds(20, 100, 300, 700);
		ingredients_area.setBackground(Color.LIGHT_GRAY);
		ingredients_area.setFont(new Font("Serif", Font.ITALIC, 16));
		p.add(ingredients_scroll);
		
		main_frame.add(p); //to jest window param klasy
		main_frame.setVisible(true);
		
		next_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				if(counter == 0)
				{
					counter = 1;
					precipe_area.setText(precipes_and_indgredients[counter + 1]);
					ingredients_area.setText(precipes_and_indgredients[counter + 2]);
				}
				else
				{
					counter = 0;
					precipe_area.setText(precipes_and_indgredients[counter]);
					ingredients_area.setText(precipes_and_indgredients[counter + 1]);
				}
			} 
		});	
		
        previous_page_button.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) 
			{ 
				if(counter == 0)
				{
					counter = 1;
					precipe_area.setText(precipes_and_indgredients[counter + 1]);
					ingredients_area.setText(precipes_and_indgredients[counter + 2]);
				}
				else
				{
					counter = 0;
					precipe_area.setText(precipes_and_indgredients[counter]);
					ingredients_area.setText(precipes_and_indgredients[counter + 1]);
				}
			} 
		});	
        
        String fileName0 = "przepis1.txt";
        String fileName1 = "skladniki1.txt";
        String fileName2 = "przepis2.txt";
        String fileName3 = "skladniki2.txt";
        String line = null;
        
        try {
            FileReader fileReader0 = new FileReader(fileName0);
            FileReader fileReader1 = new FileReader(fileName1);
            FileReader fileReader2 = new FileReader(fileName2);
            FileReader fileReader3 = new FileReader(fileName3);
            
            BufferedReader bufferedReader0 = new BufferedReader(fileReader0);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            BufferedReader bufferedReader3 = new BufferedReader(fileReader3);     
            
            precipes_and_indgredients[0] = bufferedReader0.readLine();
            while((line = bufferedReader0.readLine()) != null) 
            {
            	precipes_and_indgredients[0] += "\n" + line;
            }   
            precipes_and_indgredients[1] = bufferedReader1.readLine();
            while((line = bufferedReader1.readLine()) != null) 
            {
            	precipes_and_indgredients[1] += "\n" + line;
            }   
            precipes_and_indgredients[2] = bufferedReader2.readLine();
            while((line = bufferedReader2.readLine()) != null) 
            {
            	precipes_and_indgredients[2] += "\n" + line;
            }   
            precipes_and_indgredients[3] = bufferedReader3.readLine();
            while((line = bufferedReader3.readLine()) != null) 
            {
            	precipes_and_indgredients[3] += "\n" + line;
            }   
            bufferedReader0.close();
            bufferedReader1.close();  
            bufferedReader2.close();  
            bufferedReader3.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");                
        }
        catch(IOException ex) {
            System.out.println( "Error reading file");                  
        }
	}

	public static boolean get_logged() {
		return logged;
	}

	public static void set_logged(boolean logged) {
		MainFrame.logged = logged;
	}
}

