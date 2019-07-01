package mechanics;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiFacade {

	private Book book;
	
	public GuiFacade() 
	{
		book = new Book();
		//Może tutaj coś bardziej skomplikowanego być póniej idunno
	}
	
	public void saveRecipes()
	{
		book.saveRecipes();
	}
	
	public HashMap<Integer,String> SearchTitles(String name)
	{
		HashMap<Integer,String> equal_titles = book.searchTitles(name);
		return equal_titles;
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

	/*
	public String [] searchRecipe(String name)
	{
		String [] str = new String [2];
		str = book.searchRecipe(name);
		return str;
	}
	*/			//  Currently unnecessary
	
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
