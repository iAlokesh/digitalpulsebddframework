package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

/**
 *  This class contains all the required locators and methods to interact with Search Result Page of the application
 *  
 * @author Alokesh Dey
 */
public class SearchResultPage {
	
	// Variables
	
	WebDriver driver;
	
	/**
	 * Constructor of the class
	 * 
	 * @param driver has been passed to do operations on browser
	 */
	public SearchResultPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// Locators
	
	private By searchResultCount = By.xpath("//h2[contains(text(),'Results for')]");
	
	//Methods
	
	/**
	 * Validate the Page Title
	 * 
	 * @param expPageTitle expected page title to be provided from testdata
	 */
	public void validatePageTitle(String expPageTitle) {

		String actualPageTitle = driver.getTitle();

		assertEquals(actualPageTitle, expPageTitle);
	}
	
	/**
	 * Get the search result count
	 * 
	 * @return searchResultCount number of search result appeared on the search result page
	 */
	public int getSearchResultCount() {
		
		String searchResultCountText = driver.findElement(searchResultCount).getText();
		String[] searchResultCount = searchResultCountText.split(" ");
		
		return Integer.parseInt(searchResultCount[0]);
	}
	
	/**
	 * Validate that the search result displayed at least 1(One) Result
	 */
	public void validateSearchResultDisplayedAtLeast1Result() {
		
		int searchResultCount = getSearchResultCount();
			
			assertTrue(searchResultCount == 1 || searchResultCount>1);			
	}
}