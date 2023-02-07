package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *  This class contains methods for launching, closing browser 
 *  
 * @author Alokesh Dey
 */
public class BaseTest {

	// Variables
	
	WebDriver driver;

	// Methods
	
	/**
	 * Launch Browser
	 * 
	 * @param URL
	 * @return driver instance of the Web Browser
	 * @throws InterruptedException
	 */
	public WebDriver launchBrowser(String URL) throws InterruptedException {

		if (driver == null) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			Thread.sleep(10000);
		}
		return driver;
	}

	/**
	 * Close all active windows of the browser
	 */
	public void killBrowser() {

		driver.quit();
	}

	/**
	 * Take a screenshot
	 * 
	 * @return screenShot in byte format
	 */
	public byte[] takeScreenshot() {

		final byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenShot;
	}
}
