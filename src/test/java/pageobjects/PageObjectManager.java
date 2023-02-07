package pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * This class is for managing all Page Object classes, as it would be
 * responsible for creating instances of the page object classes
 * 
 * @author Alokesh Dey
 */
public class PageObjectManager {

	// Variables

	WebDriver driver;
	HomePage homePage;
	CommonHeader commonHeader;
	SearchResultPage searchResultPage;
	SubscribePage subscribePage;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}

	// Methods

	/**
	 * Method to create object for HomePage class
	 * 
	 * @return homePage instance
	 */
	public HomePage getHomePageObj() {

		homePage = new HomePage(driver);
		return homePage;
	}

	/**
	 * Method to create object for CommonHeader class
	 * 
	 * @return commonHeader instance
	 */
	public CommonHeader getCommonHeaderObj() {

		commonHeader = new CommonHeader(driver);
		return commonHeader;
	}

	/**
	 * Method to create object for SearchResultPage class
	 * 
	 * @return searchResultPage instance
	 */
	public SearchResultPage getSearchResultPageObj() {

		searchResultPage = new SearchResultPage(driver);
		return searchResultPage;
	}

	/**
	 * Method to create object for SubscribePage class
	 * 
	 * @return subscribePage instance
	 */
	public SubscribePage getSubscribePageObj() {

		subscribePage = new SubscribePage(driver);
		return subscribePage;
	}
}
