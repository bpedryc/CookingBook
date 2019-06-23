package main_class;
import java.awt.Rectangle;

import ksiazka_kucharska_gui.Guest_user;
import ksiazka_kucharska_gui.Logged_user;
import ksiazka_kucharska_gui.MainFrame;

public class Main_class {
	
	
	public static void main(String[] args)
	{
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);;
		while(true) 
		{
			MainFrame object = new Guest_user(dimensions);
			while(object.get_logged() == false)
			{
				if(object.get_logged() == true)
				{
					break;
				}
				object.extra_things();
			}
			dimensions = MainFrame.main_frame.getBounds();
			object = (MainFrame)new Logged_user(dimensions);
			while(object.get_logged() == true)
			{
				if(object.get_logged() == false)
				{
					break;
				}
				object.extra_things();
			}
			dimensions = MainFrame.main_frame.getBounds();
		}
	}
}


