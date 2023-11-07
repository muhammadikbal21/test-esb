Feature: Login

  Background: User can login
    Given User access to url orangehrm
    And User input valid username
    And User input valid password
    When User click login button
    Then User redirect to dashboard

  Scenario: User is on dashboard
    Then User see dashboard page

  Scenario: User can logout
    When User click account
    Then User redirect to login page