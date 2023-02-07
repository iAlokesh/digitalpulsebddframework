Feature: Digital Pulse Web Apllication Validation

    @One
    Scenario: Validate the number of articles present in the Homepage
    Given I navigate to the PwC Digital Pulse website
    When I am viewing the Home page
    Then I am presented with 3 columns of articles
    And The left column is displaying 2 articles
    And The middle column is displaying 1 articles
    And The right column is displaying 4 articles
    
    @Two
    Scenario: Validate that the search result page presented atleast 1 result
    Given I navigate to the PwC Digital Pulse website
    When I click on the Magnifying glass icon to perform a search
    And I enter the text 'Single page applications'
    And I submit the search
    Then I am taken to the search result page
    And I am presented with at least 1 search result

    @Three
    Scenario: Validate the fields present in the Subscribe page
    Given I navigate to the PwC Digital Pulse website
    And I am viewing the Home page
    When I click on the Subscribe navigation link
    Then I am taken to the Subscribe page
    And I am presented with the below fields
    | Field                  | Required | Type|
    | First name             | true     | text|
    | Last name							 | true     | text| 
    | Organisation           | true     | text|
    | Job title						   | true     | text|
    | Business email address | true     | text|
    | State							     | true     | dropdown|
    | Country							   | true     | dropdown|
    And I will need to complete Google reCAPTCHA before I can complete my request