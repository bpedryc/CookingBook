package mechanics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import database.ResourceManager;

public class Book {

	private int recipe_id;
	private List<Recipe> recipes;
	private int actual_it;
	private int searching_type;
	private boolean log_status;
	private String user_name;
	
	public Book()
	{
		recipe_id = 0;
		searching_type = 2;
		actual_it = -1;
		recipes = new ArrayList<Recipe>();
		setLogStatus(false);
		loadRecipes();
	}
	
	public void deleteRecipe(int it)
	{
		if(recipes.isEmpty())
		recipes.remove(it);
		if (it > recipes.size()-1)
		{
			it--;
		}
	}
	
	public int getActualIt()
	{
		return actual_it;
	}
	
	public int getSearchingType()
	{
		return searching_type;
	}
	
	public String[] getPrevRecipe()
	{
		String[] text = new String[2];
		
		if (!(actual_it < 1 ))
		{
			actual_it --;
		}
		
		text = getAtributesToString();
		
		return text;
	}
	
	public String[] getNextRecipe()
	{
		//System.out.println(recipes.size());
		
		String[] text = new String[2];
		
		if (!(actual_it == -1 || actual_it >= recipes.size()-1))
		{
			actual_it ++;
		}
		
		text = getAtributesToString();
		
		return text;
	}

	public String getUserName() 
	{
		return user_name;
	}
	
	public String[] getChosenRecipe(int index_of_recipe)
	{
		String[] text = new String[2];
		
		if (!(index_of_recipe < 0 || index_of_recipe >= recipes.size()))
		{
			text = new String[2];
			actual_it = index_of_recipe;
			text = getAtributesToString();
		}
		
		return text;
	}
	
	public ArrayList<String> getTitles()
	{
		ArrayList<String> titles = new ArrayList<String>();
		for(Recipe var : recipes)
		{
			titles.add(var.getTitle());
		}
		
		return titles;
	}
	
	public void setSearchingType(String searching_filter)
	{

		if(searching_filter == "Nazwa przepisu")
		{
			searching_type = 0;
		}
		
		else if(searching_filter == "Autor")
		{
			searching_type = 1;
		}
		
		else if(searching_filter == "Składniki")
		{
			searching_type = 2;
		}
	}
	
	public void setUserName(String user_name) 
	{
		this.user_name = user_name;
	}
	
	public void setLogStatus(boolean log_status)
	{
		this.log_status = log_status;
	}
	
	public void loadRecipes()
	{
		ResourceManager res_manager = new ResourceManager();
		recipes = res_manager.fetchRecipes();
		recipe_id = recipes.get(recipes.size()-1).getId();
	}
	
	public void saveRecipes()
	{
		ResourceManager res_manager = new ResourceManager();
		res_manager.saveRecipes(recipes);
	}
	
	public HashMap<Integer,String> searchIngredients(String name)
	{
		HashMap<Integer, String> equal_titles = new HashMap<Integer, String>();
		for(int i = 0; i < recipes.size(); i++)
		{
			for(int j = 0; j< recipes.get(i).getIngredients().size(); j++)
			{
				if(recipes.get(i).getIngredients().get(j).toLowerCase().startsWith(name.toLowerCase()))
				{
					equal_titles.put(i,recipes.get(i).getTitle());
					break;
				}
			}

		}
		return equal_titles;
	}
	
	public HashMap<Integer,String> searchAuthors(String name)
	{
		HashMap<Integer, String> equal_authors = new HashMap<Integer, String>();
		for(int i = 0; i < recipes.size(); i++)
		{
			if(recipes.get(i).getAuthor().toLowerCase().startsWith(name.toLowerCase()))
			{
				equal_authors.put(i,recipes.get(i).getTitle());
			}
		}
		return equal_authors;
	}
	
	public HashMap<Integer,String> searchTitles(String name)
	{
		HashMap<Integer, String> equal_titles = new HashMap<Integer, String>();
		for(int i = 0; i < recipes.size(); i++)
		{
			if(recipes.get(i).getTitle().toLowerCase().startsWith(name.toLowerCase()))
			{
				equal_titles.put(i,recipes.get(i).getTitle());
			}
		}
		return equal_titles;
	}
	
	public String[] getAtributesToString()
	{
		String[] text = new String[2];
		text[1] = "";
		
		for(int i = 0; i < recipes.get(actual_it).getIngredients().size(); i++)
		{
			text[1] += recipes.get(actual_it).getIngredients().get(i) + "\n";
		}
		
		text[0] = recipes.get(actual_it).getTitle() + "\n"; 
		text[0] += recipes.get(actual_it).getAuthor() + "\n"; 
		text[0] += recipes.get(actual_it).getRating() + "\n"; 
		text[0] += recipes.get(actual_it).getPrep_time() + "\n"; 
		text[0] += recipes.get(actual_it).getDescription() + "\n"; 
		
		return text;
	}
	
	private boolean testRecipe(String [] splitedArray)
	{
		if (splitedArray.length < 4)
		{
			return false;
		}
		
		for (int i = 0; i < 4; i++)
		{
			if (splitedArray[i].contentEquals(""))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private boolean testIngredients(String [] splitedArray)
	{
		for (int i = 0; i < splitedArray.length; i++)
		{
			if (!(splitedArray[i].contentEquals("")))
			{
				return true;
			}
		}
		
		return false;
	}
	
	// title,author, rating, prep_time, description| ingredients
	public boolean createRecipe(String recipes_str, String ingredients_str)
	{
		recipe_id++;		
		String desc="";
		String splited = new String(recipes_str);
		String[] splitedArray = null;
		splitedArray = splited.split("\n");

		if (testRecipe(splitedArray) == false)
		{
			return false;
		}

		for (int i = 4 ; i < splitedArray.length ; i++) 
		{
		    desc += splitedArray[i];
		}
		
		ArrayList<String> ingred = new ArrayList<String>();
		String splited2 = new String(ingredients_str);
		String[] splitedArray2 = null;
		splitedArray2 = splited2.split("\n");
		
		if (testIngredients(splitedArray2) == false)
		{
			return false;
		}
		
		for (int i = 0 ; i < splitedArray2.length ; i++) 
		{
		     ingred.add(splitedArray2[i]);
		}
		
		Recipe recipe = new Recipe.Builder(recipe_id)
			.author(splitedArray[1])
			.title(splitedArray[0])
			.rating(splitedArray[2])
			.prep_time(splitedArray[3])
			.ingredients(ingred)
			.description(desc)
			.build();
		
		recipes.add(recipe);
		//System.out.println(recipe.toString());
		
		return true;
	}
	/*	public HashMap<Integer,String> search(String name)
	{
		boolean accept = false;
		HashMap<Integer, String> equal_titles = new HashMap<Integer, String>();
		for(int i = 0; i < recipes.size(); i++)
		{
			if(type_of_search == 0)
			{
				if(recipes.get(i).getTitle().toLowerCase().startsWith(name.toLowerCase()))
				{
					accept = true;
				}
			}
			else if(type_of_search == 1)
			{
				if(recipes.get(i).getAuthor().toLowerCase().startsWith(name.toLowerCase()))
				{
					accept = true;
				}
			}
			else
			{
				for(int j = 0; j< recipes.get(i).getIngredients().size(); j++)
				{
					if(recipes.get(i).getIngredients().get(j).toLowerCase().startsWith(name.toLowerCase()))
					{
						accept = true;
						break;
					}
				}
			}
			if(accept == true)
			{
				equal_titles.put(i,recipes.get(i).getTitle());
				accept = false;
			}
		}
		return equal_titles;
	}
	*/ //currently unnecessary

/*	public String [] searchRecipe(String name)
	{
		Vector<String> low_recipe_titles = new Vector<String>();
		name = name.toLowerCase();
		String [] find_recipe = new String [2];
		for(int i = 0; i < recipes.size(); i++)
		{
			low_recipe_titles.add(recipes.get(i).getTitle().toLowerCase());
			//System.out.println(low_recipe_titles.get(i));
			//System.out.println(name);
			if(low_recipe_titles.get(i).startsWith(name))
			{
				//System.out.println("weszlem tu");
				find_recipe = getChosenRecipe(i);
				return find_recipe;
			}
		}
		String [] empty = {"",""};
		return empty;
	}
*/		// Currently unnecessary
}
