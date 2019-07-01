package main;

import java.awt.Rectangle;

import gui.*;
import mechanics.*;

public class MainClass {
	public static void main(String[] args){
	
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);
		GuiFacade facade = new GuiFacade();
		facade.createBook();
		MainWindow window = new MainWindow(dimensions, facade);
		
		/*
		while(true) 
		{
			BaseMenu object = new GuestMenu(dimensions);
			BaseMenu.main_frame.getContentPane().repaint();
			while(object.get_logged() == false)
			{
				if(object.get_logged() == true)
				{
					break;
				}
				object.extraThings();
			}
			dimensions = BaseMenu.main_frame.getBounds();
			object = (BaseMenu)new LoggedMenu(dimensions);
			BaseMenu.main_frame.getContentPane().repaint();
			System.out.println(object);
			while(object.get_logged() == true)
			{
				if(object.get_logged() == false)
				{
					break;
				}
				object.extraThings();
			}
			dimensions = BaseMenu.main_frame.getBounds();
		}
	*/
	}
}



