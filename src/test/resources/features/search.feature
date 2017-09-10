Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the input box search result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the input box search result should be displayed (screenplay)

  @ui @screenplay
  Scenario: Should be able to search for a product from the drop-down menu (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the drop-down menu (screenplay)
    Then the drop-down menu search result should be displayed (screenplay)

  @ui @screenplay
  Scenario: Should be able to search for a product from the icons (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he clicks on a product icon (screenplay)
    Then the relevant product matrix should be displayed (screenplay)

  @ui @screenplay
  Scenario: Should be able to navigate to the login page (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he clicks on the sign-in button (screenplay)
    Then the login page should be presented (screenplay)

  @interview @pageobject
  Scenario: Should be able to search for cheese in Google
    Given I am on the Google Home page
    When I enter cheese into the search box
    And I click search
    Then I should see results showing cheese

  @interview @wip
  Scenario: Should be able to login to Gmail
    Given I am on the Gmail Home page
    When I enter my valid credentials
    And I click login
    Then I should see my inbox
