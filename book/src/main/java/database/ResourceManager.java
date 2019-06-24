package database;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Vector;

import mechanics.Book;
import mechanics.Recipe;

public class ResourceManager {
	public Vector<Recipe> fetchRecipes(){
		Vector<Recipe> return_vector = new Vector<Recipe>();
		try {
			File xml_file = new File("src/main/resources/recipes.xml");
			DocumentBuilderFactory db_factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder d_builder = db_factory.newDocumentBuilder();
			Document doc = d_builder.parse(xml_file);
			doc.getDocumentElement().normalize();
			NodeList nlist = doc.getElementsByTagName("recipe");
			
			for (int i = 0; i < nlist.getLength(); i++) {
				Node nnode = nlist.item(i);
				
				if (nnode.getNodeType() == Node.ELEMENT_NODE) {
					Element eelement = (Element)nnode;
					NodeList ingredients_nlist = eelement.getElementsByTagName("ingredients");
					for (int j = 0; j < ingredients_nlist; j++) {
						
					}
					Recipe recipe = new Recipe.Builder(eelement.getAttribute("id")
						.author(eelement.getElementsByTagName("").item(0).getTextContent())
						.title(eelement.getElementsByTagName("").item(0).getTextContent())
						.rating(eelement.getElementsByTagName("").item(0).getTextContent())
						.prep_time(eelement.getElementsByTagName("").item(0).getTextContent())
						.ingredients(eelement.getElementsByTagName("").item(0).getTextContent())
						.description(eelement.getElementsByTagName("").item(0).getTextContent())
						.build();
					return_vector.add(recipe);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return return_vector;
	}
	

	
}
