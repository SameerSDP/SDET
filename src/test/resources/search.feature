Feature: Search functionality
  User want to search product on site

  Background: 
    Given the user is on the website page

  @Search
  Scenario Outline: User search valide product category on site
    When User clicks search icon
    And  User enters search input "<search>"
    Then User able to see search result

    Examples: 
      | search    |
      | red shirt |

  #  | pant |
  
  @selectProduct
  Scenario Outline: User selects a specific product from the search results
    When User clicks search icon
    And  User enters search input "<search>"
    Then User able to see search result
    Then the user selects a specific product from the search results with "<productName>"
    And  navigates to the product details page

    Examples: 
      |search  		| productName              |
      | red shirt | AWEARNESS Kenneth Cole|

	@SearchAndAddtoBag
  Scenario Outline: User adds the selected product to the shopping cart
    When User clicks search icon
    And User enters search input "<search>"
    Then User able to see search result
    Then the user selects a specific product from the search results with "<productName>"
    And navigates to the product details page
    And the user selects "<color>" and "<size>" of product
    And the user adds the selected product to the shopping cart
    Then user able to see Add to Bag confirmation pop up
    When User clicks on Checkout
    Then User able to see Cart page with product "<productName>"

    Examples: 
      | productName              | search    | color   | size  |
      |AWEARNESS Kenneth Cole			| red shirt | Black | M |
