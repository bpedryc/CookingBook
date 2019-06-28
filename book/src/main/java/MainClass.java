import java.awt.Rectangle;
import gui.GuestMenu;
import gui.LoggedMenu;
import gui.BaseMenu;

public class MainClass {
	
	public static void main(String[] args)
	{
		Rectangle dimensions = new Rectangle(300, 100, 1100, 900);;
		while(true) 
		{
			BaseMenu object = new GuestMenu(dimensions);
			while(object.get_logged() == false)
			{
				if(object.get_logged() == true)
				{
					break;
				}
				object.extra_things();
			}
			dimensions = BaseMenu.main_frame.getBounds();
			object = (BaseMenu)new LoggedMenu(dimensions);
			while(object.get_logged() == true)
			{
				if(object.get_logged() == false)
				{
					break;
				}
				object.extra_things();
			}
			dimensions = BaseMenu.main_frame.getBounds();
		}
		
	}
}


