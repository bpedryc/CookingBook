package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import mechanics.Recipe;

/**
 * Menedżer zasobów w projekcie
 * Odpowiedzialny za takie zadania jak: pozyskanie zapisanych przepisów 
 * z pliku lub zapisanie przepisów w pliku
 * @author Bartek
*/
public class ResourceManager 
{
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
