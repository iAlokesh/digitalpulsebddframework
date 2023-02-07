package stepdefinitionfiles;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utility.TestContext;

/**
 *  This class contains block of code which gets triggered before and after scenario
 *  
 * @author Alokesh Dey
 */
public class Hooks {

	TestContext testContext;

	public Hooks(TestContext testContext) {

		this.testContext = testContext;
	}

	/**
	 * This method is for taking screenshot on failure and closing all active browser windows. It would execute at the end of the execution
	 * 
	 * @param scenario
	 */
	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			scenario.attach(testContext.baseTest.takeScreenshot(), "image/png", scenario.getName());
		}
		testContext.baseTest.killBrowser();
	}
}
