import java.util.Vector;
import java.util.ArrayList;

public class Book {

	private int recipe_id;
	private Vector<Recipe> recipes = new Vector<Recipe>();
	private int actual_it=-1;
	
	public Book()
	{
		recipe_id = 0;
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
	
	public String[] getAtributesToString()
	{
		String[] text = new String[2];
		text[0] = recipes.get(actual_it).getIngredients();
		text[1] = recipes.get(actual_it).getTitle() + "\n"; 
		text[1] += recipes.get(actual_it).getAuthor() + "\n"; 
		text[1] += recipes.get(actual_it).getRating() + "\n"; 
		text[1] += recipes.get(actual_it).getPrep_time() + "\n"; 
		text[1] += recipes.get(actual_it).getDescription() + "\n"; 
		return text;
	}
	
	public String[] getPrevRecipe()
	{
		if (!(actual_it < 1 ))
		{
			String[] text = new String[2];
			actual_it --;
			text = getAtributesToString();
			return text;
		}
		else
		{
			String [] empty = {"",""};
			return empty;
		}
	}
	
	public String[] getNextRecipe()
	{
		//System.out.println(recipes.size());
		if (!(actual_it == -1 || actual_it >= recipes.size()-1))
		{
			String[] text = new String[2];
			actual_it ++;
			text = getAtributesToString();
			return text;
		}
		else
		{
			String [] empty = {"",""};
			return empty;
		}
	}

	public String[] getChosenRecipe(int index_of_recipe)
	{
		if (!(index_of_recipe < 0 || index_of_recipe >= recipes.size()))
		{
			String[] text = new String[2];
			actual_it = index_of_recipe;
			text = getAtributesToString();
			return text;
		}
		else
		{
			String [] empty = {"",""};
			return empty;
		}
	}
	
	// title,author, rating, prep_time, description| ingredients
	
	public boolean createRecipe(String recipes_str, String ingredients_str)
	{
		
		if (recipes_str.isEmpty() || ingredients_str.isEmpty())	
			return false;
		
		recipe_id++;
		
		String desc="";
		String splited = new String(recipes_str);
		String[] splitedArray = null;
		splitedArray = splited.split("\n");

		for (int i = 4 ; i < splitedArray.length ; i++) {
		    desc += splitedArray[i];
		}
		
		Recipe recipe = new Recipe.Builder(recipe_id)
			.author(splitedArray[1])
			.title(splitedArray[0])
			.rating(splitedArray[2])
			.prep_time(splitedArray[3])
			.ingredients(ingredients_str)
			.description(desc)
			.build();
		
		recipes.add(recipe);
		//System.out.println(recipe.toString());
		
		return true;
	}
}
