package mechanics;
import java.util.Vector;

public class Book {

	private int recipe_id;
	private Vector<Recipe> recipes = new Vector<Recipe>();
	
	public Book()
	{
		recipe_id = 0;
	}
	
	public boolean createRecipe(String recipes, String ingredients)
	{
		// title,author, rating, prep_time,number_of_ingredients, ingredients, description
		recipe_id++;
		
		String desc="";
		String splited = new String(recipes);
		String[] splitedArray = null;
		splitedArray = splited.split("\n");

		for (int i = 4 ; i < splitedArray.length ; i++) {
		    desc += splitedArray[i];
		}
		
		Vector<String> ingredient = new Vector<String>(); 
		
		splited = new String(ingredients);
		String [] splitedArray2 = null;
		splitedArray2 = splited.split("\n");
		for (int i = 0 ; i < splitedArray2.length ; i++) {
		    ingredient.add(splitedArray2[i]);
		}
		
		
		Recipe recipe = new Recipe.Builder(recipe_id)
			.author(splitedArray[1])
			.title(splitedArray[0])
			.rating(splitedArray[2])
			.prep_time(splitedArray[3])
			.ingredients(ingredient)
			.description(desc)
			.build();
		
		System.out.println(recipe.toString());
		
		return true;
	}
}
