package stepdefinitionfiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestContext;

/**
 *  This class contains Step definition for Home Page
 *  
 * @author Alokesh Dey
 */
public class HomePageStepDefinition {

	TestContext testContext;

	public HomePageStepDefinition(TestContext testContext) throws InterruptedException {

		this.testContext = testContext;
	}

	@Given("I navigate to the PwC Digital Pulse website")
	public void i_navigate_to_the_pw_c_digital_pulse_website() throws InterruptedException {

		// Validating the current URL of Homepage of the Website
		testContext.pageObjectManager.getHomePageObj()
				.validateCurrentURL(testContext.edr.getDataFromTestcasePriority("Scenario1", "CurrentURL", 2));
	}

	@When("I am viewing the Home page")
	public void i_am_viewing_the_home_page() {

		// Validating the Page Title of the Homepage
		testContext.pageObjectManager.getHomePageObj()
				.validatePageTitle(testContext.edr.getDataFromTestcasePriority("Scenario1", "PageTitle", 2));
	}

	@Then("I am presented with {int} columns of articles")
	public void i_am_presented_with_columns_of_articles(Integer numberOfExpectedColumnsWithArticles) {

		// Validating the number of columns which contain articles
		testContext.pageObjectManager.getHomePageObj()
				.validateTheNumberOfColumnsForAticles(numberOfExpectedColumnsWithArticles);
	}

	@Then("The left column is displaying {int} articles")
	public void the_left_column_is_displaying_articles(Integer numberOfArticles) {

		// Validating the number of articles present on the left column of Homepage
		testContext.pageObjectManager.getHomePageObj()
				.validateTheNumberOfArticlesPresentInTheLeftColumnOfHomePage(numberOfArticles);
	}

	@Then("The middle column is displaying {int} articles")
	public void the_middle_column_is_displaying_articles(Integer numberOfArticles) {

		// Validating the number of articles present on the middle column of Homepage
		testContext.pageObjectManager.getHomePageObj()
				.validateTheNumberOfArticlesPresentInTheMiddleColumnOfHomePage(numberOfArticles);
	}

	@Then("The right column is displaying {int} articles")
	public void the_right_column_is_displaying_articles(Integer numberOfArticles) {

		// Validating the number of articles present on the right column of Homepage
		testContext.pageObjectManager.getHomePageObj()
				.validateTheNumberOfArticlesPresentInTheRightColumnOfHomePage(numberOfArticles);
	}
}
