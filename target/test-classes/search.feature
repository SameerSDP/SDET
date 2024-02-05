Feature: Search functionality
  I want to search product on site

  Background: 
    Given the user is on the website page
    
    @Search
  Scenario Outline: User search valide product category on site
    When User clicks search icon
    And User enters search input "<search>" 
    Then User able to see search result
    
    Examples: 
      | search |
      | red shirt | 
    #  | pant |
    
    