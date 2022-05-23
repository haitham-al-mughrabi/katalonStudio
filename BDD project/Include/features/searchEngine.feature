Feature: test data table

  Scenario: data table
    Given user data table
      | key       | variable      |
      | name      | Haitham       |
      | birthdate | 25/1/1995     |
      | address   | Amman, Jordan |
    When user calcualte his age
    Then his age should equial 27
