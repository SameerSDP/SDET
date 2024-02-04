Feature: Login Functionality
  I want to login into ecommerce website

  Background: 
    Given the user is on the website page

  @Login
  Scenario Outline: User successfully login with valid information
    When User clicks sign in button
    Then User enters username "<username>" and password "<password>" and click login
    And user should be logged in successfully

    Examples: 
      | username               | password |
      | testecomm335@gmail.com | Test@123 |

  @Signup
  Scenario Outline: User successfully signs up with valid information
    When User clicks sign up button
    Then User enters valid registration details with Firstname "<firstName>", Lastname "<lastName>", email "<email>", and password "<password>"
    And User should see User created

    Examples: 
      | firstName | lastName | email                   | password | error_message               |
      | same      | test     | testecomm3+03@gmail.com | Test@123 | "Username is already taken" |
