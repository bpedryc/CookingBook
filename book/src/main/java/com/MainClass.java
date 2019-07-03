package com;

import java.awt.Rectangle;

import com.gui.*;
import com.mechanics.*;

public class MainClass {
	public static void main(String[] args){
	
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);
		GuiFacade facade = new GuiFacade();
		MainWindow window = new MainWindow(dimensions, facade);
		
	}
}



