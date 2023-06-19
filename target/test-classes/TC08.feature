@parallel2
Feature: Location test
  Scenario: user should be able to change region and language settings
    Given user goes to base url
    And user clicks the region settings
    And user selects region "Turkey"
    And user selects Language "English (US)"
    And user selects Currency "TRY"
    Then user verifies that the page is loaded with the correct region option "TL"