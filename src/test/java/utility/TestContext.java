package utility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import pageobjects.PageObjectManager;

/**
 *  This class holds all the objects state
 *  
 * @author Alokesh Dey
 */
public class TestContext {

	// Variables
	
	public WebDriver driver;
	public PropertiesDataReader pdr;
	public ExcelDataReader edr;
	public BaseTest baseTest;
	public PageObjectManager pageObjectManager;

	/**
	 * Constructor of the class to create instances of BaseTest, PropertiesDataReader, ExcelDataReader and PageObjectManager
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public TestContext() throws InterruptedException, IOException {

		this.baseTest = new BaseTest();
		this.pdr = new PropertiesDataReader();
		this.edr = new ExcelDataReader();
		this.pageObjectManager = new PageObjectManager(baseTest.launchBrowser(pdr.getProperty("URL")));
	}
}
