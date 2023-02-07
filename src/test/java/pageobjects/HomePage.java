package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

/**
 *  This class contains all the required locators and methods to interact with Homepage of the application
 *  
 * @author Alokesh Dey
 */
public class HomePage {

	// Variables
	
	WebDriver driver;

	/**
	 * Constructor of the class
	 * 
	 * @param driver has been passed to do operations on browser
	 */
	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators
	
	private By numberOfColumnsOfArticles = By.xpath("//div[contains(@class,'headline_column')]");
	private By numberOfArticleInTheLeftColumn = By.xpath("//div[@class='headline_column2']/article");
	private By numberOfArticleInTheMiddleColumn = By.xpath("//div[@class='headline_column1']/article");
	private By numberOfArticleInTheRightColumn = By.xpath("//div[@class='headline_column3']/article");

	// Methods
	
	/**
	 * Validate current URL
	 * 
	 * @param expPageURL expected URL to be provided from testdata
	 */
	public void validateCurrentURL(String expPageURL) {

		String actualPageURL = driver.getCurrentUrl();
		
		//Assert.assertEquals(actualPageURL, expPageURL);
		assertEquals(expPageURL, actualPageURL);
	}

	/**
	 * Validate the Page Title
	 * 
	 * @param expPageTitle expected page title to be provided from testdata
	 */
	public void validatePageTitle(String expPageTitle) {

		String actualPageTitle = driver.getTitle();

		//Assert.assertEquals(actualPageTitle, expPageTitle);
		assertEquals(actualPageTitle, expPageTitle);
	}

	/**
	 * Validate the number of columns for articles
	 * 
	 * @param numberOfExpectedColumnsForArticle number of columns expected to be provided which contain articles
	 */
	public void validateTheNumberOfColumnsForAticles(int numberOfExpectedColumnsForArticle) {

		int actualNumberOfColumnsForArticles = driver.findElements(numberOfColumnsOfArticles).size();

		//Assert.assertEquals(actualNumberOfColumnsForArticles, numberOfExpectedColumnsForArticle);
		assertEquals(actualNumberOfColumnsForArticles, numberOfExpectedColumnsForArticle);
	}

	/**
	 * Validate the number of articles present on the Left Column
	 * 
	 * @param numberOfExpectedArticle number of expected articles on the left column
	 */
	public void validateTheNumberOfArticlesPresentInTheLeftColumnOfHomePage(int numberOfExpectedArticle) {

		int actualNumberOfArticles = driver.findElements(numberOfArticleInTheLeftColumn).size();

		//Assert.assertEquals(actualNumberOfArticles, numberOfExpectedArticle);
		assertEquals(actualNumberOfArticles, numberOfExpectedArticle);
	}

	/**
	 * Validate the number of articles present on the Middle Column
	 * 
	 * @param numberOfExpectedArticle number of expected articles on the middle column
	 */
	public void validateTheNumberOfArticlesPresentInTheMiddleColumnOfHomePage(int numberOfExpectedArticle) {

		int actualNumberOfArticles = driver.findElements(numberOfArticleInTheMiddleColumn).size();

		assertEquals(actualNumberOfArticles, numberOfExpectedArticle);
	}

	/**
	 * Validate the number of articles present on the Right Column
	 * 
	 * @param numberOfExpectedArticle number of expected articles on the right column
	 */
	public void validateTheNumberOfArticlesPresentInTheRightColumnOfHomePage(int numberOfExpectedArticle) {

		int actualNumberOfArticles = driver.findElements(numberOfArticleInTheRightColumn).size();

		assertEquals(actualNumberOfArticles, numberOfExpectedArticle);
	}
}
