Feature: To validate registration, logon and resource list

  Scenario: To validate registration
    Given a user registers
    Then user must receive successful token

  Scenario: To validate logon successful
    Given a user logs in
    Then user must receive successful login token

  Scenario: To validate resource list
    Given a user sends resource lists
    Then user must validate the "eve.holt@reqres.in" is valid