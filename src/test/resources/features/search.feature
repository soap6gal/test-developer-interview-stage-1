Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @wip
  Scenario: Should be able to search for a product from the drop-down menu
    Given John is viewing the Etsy landing page
    When he selects a category from drop-down menu(Grid view)
    Then results should be displayed for selected category

  @ui @wip
  Scenario: Should be able to search for a product from the icons
    Given John is viewing the Etsy landing page
    When he selects a category from the icon
    Then results should be displayed for selected icon


