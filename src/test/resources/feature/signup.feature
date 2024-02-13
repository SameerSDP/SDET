#Feature: SignUp Functionality
  #I want to register into ecommerce website
#
  #Background: 
    #Given the user is on the website page
#
  #@Signip
  #Scenario Outline: User successfully signs up with valid information
    #When User clicks sign up button
    #Then User enters valid registration details with Firstname "<firstName>", Lastname "<lastName>", email "<email>", and password "<password>"
    #And User should see User created
#
    #Examples: 
      #| firstName | lastName | email                   | password | error_message               |
      #| same      | test     | testecomm3+01@gmail.com | Test@123 | "Username is already taken" |
