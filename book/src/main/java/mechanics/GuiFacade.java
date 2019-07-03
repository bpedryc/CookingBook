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
	
	public String [] restoreResult()
	{
		String [] str = book.restoreResult();
		return str;
	}
	
	public HashMap<Integer,String> search(String name)
	{
		HashMap<Integer, String> equal_titles =  new HashMap<Integer, String>();
		if(book.getSearchingType() == 0)
		{
			equal_titles = book.searchTitles(name);
		}
		else if(book.getSearchingType() == 1)
		{
			equal_titles = book.searchAuthors(name);
		}
		
		else if(book.getSearchingType() == 2)
		{
			equal_titles = book.searchIngredients(name);
		}
		return equal_titles;
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
	
	public void deleteRecipe()
	{
		book.deleteRecipe();
	}
	
	public String tableOfContents()
	{
		return book.tableOfContents();
	}
	
	public String[] getChosenRecipe(int index_of_recipe)
	{
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
	
	public int getActualIt()
	{
		return book.getActualIt();
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
	
	public boolean logIn(String user_name)
	{
		if(user_name.contentEquals("") || user_name.contentEquals("Podaj nick..."))
		{
			return false;
		}
		
		book.setLogStatus(true);
		book.setUserName(user_name);
		
		return true;
	}
	
	public void logOut()
	{
		book.setLogStatus(false);
		book.setUserName("");
	}
	
	public int getSearchingType()
	{
		int searching_type;
		searching_type = book.getSearchingType();
		return searching_type;
	}
	
	public void setSearchingType(String searching_type)
	{
		book.setSearchingType(searching_type);
	}
	
	public ArrayList<String> getTitles()
	{
		ArrayList<String> list = new ArrayList<String>();
		list = book.getTitles();
		return list;
	}
}
