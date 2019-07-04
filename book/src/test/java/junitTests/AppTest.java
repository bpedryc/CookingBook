package junitTests;

import com.pk.java.mechanics.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	Book book = new Book();
	String info1 = new String("Kluski Śląskie\n"
			+ "Sebastian\n"
			+ "7/10\n"
			+ "70min\n"
			+ "it's a test");
	String info2 = new String("Kluski Śląskie\n"
			+ "Sebastian\n"
			+ "7/10\n"
			+ "70min\n");
	String info3 = new String("Kluski Śląskie\n"
			+ "Sebastian\n"
			+ "7/10\n");
	String ingredients1 = new String("mąka\n"
			+ "woda\n"
			+ "cabula");
	String ingredients2 = new String("");
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
   
    public void testingLoadingMethod() 
    {
    	book.loadRecipes();
    }
    
    public void testingSearchingTypes0() 
    {
    	book.setSearchingType("Nazwa przepisu");
    	assertTrue(book.getSearchingType()==0);
    }
    
    public void testingSearchingTypes1() 
    {
    	book.setSearchingType("Autor");
    	assertTrue(book.getSearchingType()==1);
    }
    
    public void testingSearchingTypes2() 
    {
    	book.setSearchingType("Składniki");
    	assertTrue(book.getSearchingType()==2);
    }
    
    public void testingCreatingRecipes5info()
    {
    	assertTrue(book.createRecipe(info1, ingredients1));
    }
    
    public void testingCreatingRecipes4info()
    {
    	assertTrue(book.createRecipe(info2, ingredients1));
    }
    
    public void testingCreatingRecipes3info_shuldBeFalse()
    {
    	assertFalse(book.createRecipe(info3, ingredients1));
    }
    
    public void testingCreatingRecipesNoIgredients_shuldBeFalse()
    {
    	assertFalse(book.createRecipe(info1, ingredients2));
    }
    
    public void testingSettingUserName()
    {
    	String name = new String("Szymon");
    	book.setUserName(name);
    	assertTrue(book.getUserName() == name);
    }
}
