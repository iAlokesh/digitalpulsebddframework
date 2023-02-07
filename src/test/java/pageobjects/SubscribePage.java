package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

/**
 * This class contains all the required locators and methods to interact with
 * Subscribe Page of the application
 * 
 * @author Alokesh Dey
 */
public class SubscribePage {

	// Variables

	WebDriver driver;
	JavascriptExecutor jse;

	/**
	 * Constructor of the class
	 * 
	 * @param driver has been passed to do operations on browser
	 */
	public SubscribePage(WebDriver driver) {

		this.driver = driver;
		jse = (JavascriptExecutor) driver;
	}

	// Locators

	By captchaCheckbox = By.xpath(
			"//div[text()='reCAPTCHA']/ancestor::div[@id='rc-anchor-container']//span[@id='recaptcha-anchor' and @role='checkbox']");
	By iFrameForReCaptcha = By.xpath("//iFrame[@title='reCAPTCHA']");

	// Methods

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
	 * Validate whether specified fields are present, types of field(text/dropdown)
	 * and mandatory or not
	 * 
	 * @param type      text/dropdown
	 * @param fieldName name of the fields
	 * @param required  true/false
	 * @throws InterruptedException
	 */
	public void fieldsValidationInSubscribePage(String type, String fieldName, String required)
			throws InterruptedException {

		if (type.equalsIgnoreCase("text") && !fieldName.equalsIgnoreCase("Business email address")) {

			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath(
					"//label[text()='" + fieldName + "']/span[@class='required']/../../input[@type='" + type + "']"));

			boolean requiredFlag = Boolean.parseBoolean(required);
			Thread.sleep(2000);

			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);

			boolean status = element.isDisplayed();

			assertEquals(status, requiredFlag);

		} else if (fieldName.equalsIgnoreCase("Business email address")) {

			Thread.sleep(3000);
			WebElement element = driver.findElement(
					By.xpath("//label[text()='" + fieldName + "']/span[@class='required']/../../input[@type='email']"));

			boolean requiredFlag = Boolean.parseBoolean(required);
			Thread.sleep(2000);

			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);

			boolean status = element.isDisplayed();

			assertEquals(status, requiredFlag);

		} else if (type.equalsIgnoreCase("dropdown")) {

			Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath("//label[text()='" + fieldName
					+ "']/span[@class='required']/../../select[@id='" + fieldName + "']"));

			boolean requiredFlag = Boolean.parseBoolean(required);
			Thread.sleep(2000);

			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);

			boolean status = element.isDisplayed();

			assertEquals(status, requiredFlag);

		}
	}

	/**
	 * Switch to iFrame to interact with the form fields
	 * 
	 * @throws InterruptedException
	 */
	public void switchToFrameForFieldsValidation() throws InterruptedException {

		Thread.sleep(5000);
		driver.switchTo().frame("sfmcform");
	}

	/**
	 * Validate Google recaptcha
	 * 
	 * @throws InterruptedException
	 */
	public void validateGoogleRecaptcha() throws InterruptedException {

		driver.switchTo().frame(driver.findElement(iFrameForReCaptcha));

		jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(captchaCheckbox));
		Thread.sleep(3000);

		boolean isReCaptchaDisplayed = driver.findElement(captchaCheckbox).isDisplayed();

		assertTrue(isReCaptchaDisplayed);
	}
}