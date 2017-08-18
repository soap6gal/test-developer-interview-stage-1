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