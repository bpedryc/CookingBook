import java.awt.Rectangle;
import java.util.List;

import gui.*;
import database.*;
import mechanics.*;

public class MainClass {
	
		// Przykładowe użycie ResourceManagera, żeby otrzymać przepisy z pliku .xml
		// Plik w którym przechowujemy przepisy: book/src/main/resources/recipes.xml
		ResourceManager resource_manager = new ResourceManager();
		List<Recipe> recipes = resource_manager.fetchRecipes();
	
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);;
	public static void main(String[] args)
	{
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);
		while(true) 
		{
			BaseMenu object = new GuestMenu(dimensions);
			System.out.println(object);
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
		
	}
}


