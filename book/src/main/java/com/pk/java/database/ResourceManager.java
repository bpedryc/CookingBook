package com.pk.java.database;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.pk.java.mechanics.Recipe;

/**
 * Menedżer zasobów w projekcie
 * Odpowiedzialny za takie zadania jak: pozyskanie zapisanych przepisów 
 * z pliku lub zapisanie przepisów w pliku
 * @author Bartek
*/
public class ResourceManager 
{
	/**
	 * Zapisuje listę przepisów do pliku zasobów projektu.
	 * Plik ten znajduje się w src/main/resources/recipes.xml
	 * @param recipes Lista przepisów
	*/
	public void saveRecipes(List<Recipe> recipes) {
		try
		{
			Element root_node = new Element("recipes");
			Document document = new Document(root_node);
			
			for (Recipe recipe: recipes) {
				Element recipe_node = new Element("recipe");
				recipe_node.setAttribute(new Attribute("id", Integer.toString(recipe.getId())));
				recipe_node.addContent(new Element("author").setText(recipe.getAuthor()));
				recipe_node.addContent(new Element("title").setText(recipe.getTitle()));
				recipe_node.addContent(new Element("rating").setText(recipe.getRating()));
				recipe_node.addContent(new Element("preptime").setText(recipe.getPrep_time()));
				
				Element ingredients_node = new Element("ingredients");
				for (String ingredient : recipe.getIngredients()) {
					ingredients_node.addContent(new Element("ingredient").setText(ingredient));
				}
				recipe_node.addContent(ingredients_node);
				
				recipe_node.addContent(new Element("description").setText(recipe.getDescription()));
			
				root_node.addContent(recipe_node);
			}
			
			XMLOutputter xml_output = new XMLOutputter();
			xml_output.setFormat(Format.getPrettyFormat());
			xml_output.getFormat().setEncoding("UTF-8");
			xml_output.output(document, new FileOutputStream("src/main/resources/recipes.xml"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Zwraca listę obiektów typu Recipe, którą pozyskuje z pliku zasobów 
	 * projektu. Plik ten znajduje się w src/main/resources/recipes.xml
	 * @return lista przepisów
	*/
	public List<Recipe> fetchRecipes(){
		List<Recipe> return_list = new ArrayList<Recipe>();
		
		String xml_file = "src/main/resources/recipes.xml";
		Document document = getSAXParsedDocument(xml_file);
		
		Element root_node = document.getRootElement();
		List<Element> nodes = root_node.getChildren();
		
		for (int i = 0; i < nodes.size(); i++) {
			Element cur_node = nodes.get(i);
			List<Element> ingredient_nodes = cur_node.getChild("ingredients").getChildren();
			List<String> ingredient_texts = new ArrayList<String>();
			for(Element ingredient_node : ingredient_nodes) {
				ingredient_texts.add(ingredient_node.getText());
			}
			
			int node_id = 0;
			try
			{
				node_id = cur_node.getAttribute("id").getIntValue();
			} catch(DataConversionException e)
			{
				e.printStackTrace();
			}
			
			Recipe new_recipe = new Recipe.Builder(node_id)
					.author(cur_node.getChildText("author"))
					.title(cur_node.getChildText("title"))
					.rating(cur_node.getChildText("rating"))
					.prep_time(cur_node.getChildText("preptime"))
					.ingredients(ingredient_texts)
					.description(cur_node.getChildText("description"))
					.build();
					
			return_list.add(new_recipe);
		}
		return return_list;
	}
	
	/**
	 * Funkcja pomocnicza pozwalająca parse'ować plik .xml
	 * o konkretnej nazwie
	 * @param file_name Nazwa pliku
	 * @return Dane pliku w postaci Document
	*/
	private Document getSAXParsedDocument(String file_name) {
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		try
		{
			document = builder.build(file_name);
		}
		catch (JDOMException | IOException e)
		{
			e.printStackTrace();
		}
		return document;
	}
	
}
