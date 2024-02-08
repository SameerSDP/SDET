Feature: Search functionality
  User want to search product on site

  Background: 
    Given the user is on the website page

  @searchAndAddtoCart
  Scenario Outline: User search specific product with SKU and adds product in cart
    When User clicks search icon
    And User enters search input "<SKU>"
    Then User able to see search result
    Then the user selects first product from the search results
    And navigates to the first product details page
    And the user selects "<color>" and "<size>" of product
    And User increase Quantity and updates "<quantity>"
    And the user adds the selected product to the shopping cart
    Then user able to see Add to Bag confirmation pop up
    When User clicks on Checkout
    Then User able to see Cart page with product "<SKU>"
    Then User validate quantity "<quantity>" of product "<SKU>" added

    Examples: 
      | SKU          | color | size | quantity |
      | MSP64LV30040 | Black | L    |        4 |

  @updateCart
  Scenario Outline: User supdates quantity of the product from cart
    When User clicks search icon
    And User enters search input "<SKU>"
    Then User able to see search result
    Then the user selects first product from the search results
    And navigates to the first product details page
    And the user selects "<color>" and "<size>" of product
    And User increase Quantity and updates "<quantity>"
    And the user adds the selected product to the shopping cart
    Then user able to see Add to Bag confirmation pop up
    When User clicks on Checkout
    Then User able to see Cart page with product "<SKU>"
    Then User validate quantity "<quantity>" of product "<SKU>" added
    When User click on edit
    And User increase Quantity and updates "<increaseQuantity>"
    And the user adds the updated product to the shopping cart
    Then User verify updated quantity of product "<SKU>" in cart as total of "<quantity>" and "<increaseQuantity>"

    Examples: 
      | SKU          | color | size | quantity | increaseQuantity |
      | MSP64LV30040 | Black | L    |        4 |                1 |
