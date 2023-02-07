package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * This class contains all the required locators and methods to interact with Common Header of the application
 * 
 * @author Alokesh Dey
 */
public class CommonHeader {
	
	// Variables
	
	WebDriver driver;
	
	/**
	 * Constructor of the class
	 * 
	 * @param driver has been passed to do operations on browser
	 */
	public CommonHeader(WebDriver driver) {
		
		this.driver = driver;
	}
	
	// Locators
	
	private By searchMagnifyGlass = By.xpath("//button[text()='Search']");
	private By searchTextField = By.xpath("//input[@placeholder='Search Digital Pulse articles']");
    private By subscribeLink = By.cssSelector("nav [navigation-title=Subscribe]");
	
    //Methods
    
	/**
	 * Click on Subscribe navigation link
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnSubscribeLnk() throws InterruptedException {
		
		driver.findElement(subscribeLink).click();
		Thread.sleep(3000);
	}
	
	/**
	 * Click on Search Magnifying Glass For Searching
	 * 
	 * @throws InterruptedException
	 */
	public void clickSearchMagnifyingGlass() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(searchMagnifyGlass).click();
		Thread.sleep(2000);
	}

	/**
	 * Enter Text to be searched
	 * 
	 * @param value Enter the value/text to be searched
	 * @throws InterruptedException
	 */
	public void entertextToBeSearched(String value) throws InterruptedException {

		driver.findElement(searchTextField).sendKeys(value);
		Thread.sleep(3000);
	}
	
	/**
	 * Submit the search
	 * 
	 * @throws InterruptedException
	 */
	public void submitTheSearch() throws InterruptedException {
		
		driver.findElement(searchTextField).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
}
