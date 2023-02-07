package stepdefinitionfiles;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestContext;

/**
 *  This class contains Step definition for Subscribe Page
 *  
 * @author Alokesh Dey
 */
public class SubscribePageStepDefinition {

	TestContext testContext;

	public SubscribePageStepDefinition(TestContext testContext) throws InterruptedException {

		this.testContext = testContext;
	}

	@When("I click on the Subscribe navigation link")
	public void i_click_on_the_subscribe_navigation_link() throws InterruptedException {

		// Click on the Subscribe link from the top header
		testContext.pageObjectManager.getCommonHeaderObj().clickOnSubscribeLnk();
	}

	@Then("I am taken to the Subscribe page")
	public void i_am_taken_to_the_page() {

		// Validate the Page Title for the Subscribe page
		testContext.pageObjectManager.getSubscribePageObj()
				.validatePageTitle(testContext.edr.getDataFromTestcasePriority("Scenario3", "PageTitle", 2));
	}

	@Then("I am presented with the below fields")
	public void i_am_presented_with_the_below_fields(DataTable dataTable) throws InterruptedException {

		// Switch to iFrame to validate fieds
		testContext.pageObjectManager.getSubscribePageObj().switchToFrameForFieldsValidation();

		// Initialize data table
		List<List<String>> data = dataTable.asLists(String.class);

		// Looping the dataset
		for (List<String> d : data) {
			System.out.print("d: " + d.get(0) + "--" + d.get(1) + "--" + d.get(2));
			if (d.get(0).equalsIgnoreCase("Field")) {
				continue;
			} else {
				// Validating the name of the field, type of the field and whether its mandatory
				// or not
				testContext.pageObjectManager.getSubscribePageObj().fieldsValidationInSubscribePage(d.get(2), d.get(0),
						d.get(1));
			}
		}
	}

	@Then("I will need to complete Google reCAPTCHA before I can complete my request")
	public void i_will_need_to_complete_google_re_captcha_before_i_can_complete_my_request()
			throws InterruptedException {

		// Validating Google Recaptcha
		testContext.pageObjectManager.getSubscribePageObj().validateGoogleRecaptcha();
	}
}