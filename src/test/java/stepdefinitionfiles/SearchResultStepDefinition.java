package stepdefinitionfiles;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestContext;

/**
 *  This class contains Step definition for SearchResult Page
 *  
 * @author Alokesh Dey
 */
public class SearchResultStepDefinition {

	TestContext testContext;

	public SearchResultStepDefinition(TestContext testContext) throws InterruptedException {

		this.testContext = testContext;
	}

	@When("I click on the Magnifying glass icon to perform a search")
	public void i_click_on_the_magnifying_glass_icon_to_perform_a_search() throws InterruptedException {

		// Clicking on the Magnifying glass icon
		testContext.pageObjectManager.getCommonHeaderObj().clickSearchMagnifyingGlass();
	}

	@When("I enter the text {string}")
	public void i_enter_the_text(String value) throws InterruptedException {

		// Enter the text value to be searched
		testContext.pageObjectManager.getCommonHeaderObj().entertextToBeSearched(value);
	}

	@When("I submit the search")
	public void i_submit_the_search() throws InterruptedException {

		// Submit to search
		testContext.pageObjectManager.getCommonHeaderObj().submitTheSearch();
	}

	@Then("I am taken to the search result page")
	public void i_am_taken_to_the_search_result_page() {

		// Validate the Page Title for the Search Result page
		testContext.pageObjectManager.getSearchResultPageObj()
				.validatePageTitle(testContext.edr.getDataFromTestcasePriority("Scenario2", "PageTitle", 2));
	}

	@Then("I am presented with at least {int} search result")
	public void i_am_presented_with_at_least_search_result(Integer int1) {

		// Validate that the search result page has displayed atleast 1(One) result
		testContext.pageObjectManager.getSearchResultPageObj().validateSearchResultDisplayedAtLeast1Result();
	}
}
