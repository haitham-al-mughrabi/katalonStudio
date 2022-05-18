Feature: Login

  Scenario Outline: Test login with valid credentails
    Given User navigate to login page
    When User enters <username> and <password>
    And Click on login button
    Then User is navigated to homepage
    
  Examples:
  	| username | password |
  	| ahmad    | 1234     |
  	| sami     | 0495     |
