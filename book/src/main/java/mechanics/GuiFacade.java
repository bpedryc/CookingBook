package mechanics;

import java.util.ArrayList;

public class GuiFacade {

	private Book book;
	
	public GuiFacade()
	{
		book = new Book();
	}
	
	public boolean createRecipe(String recipes_str, String ingredients_str)
	{
		boolean bool = false;
		bool = book.createRecipe(recipes_str, ingredients_str);
		return bool;
	}
	
	public String[] getChosenRecipe(int index_of_recipe)
	{
		System.out.println("jestem tu");
		String [] string = new String [2];
		string = book.getChosenRecipe(index_of_recipe);
		return string;
	}
	
	public String[] getNextRecipe()
	{
		String [] string = new String [2];
		string = book.getNextRecipe();
		return string;
	}
	
	public String[] getPrevRecipe()
	{
		String [] string = new String [2];
		string = book.getPrevRecipe();
		return string;
	}
	
	public ArrayList<String> getTitles()
	{
		ArrayList<String> list = new ArrayList<String>();
		list = book.getTitles();
		return list;
	}
}
