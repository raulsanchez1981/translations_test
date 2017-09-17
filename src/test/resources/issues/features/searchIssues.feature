Feature: We want to test the all issues searching service for the project

  *MAIN SCENARIOS*

  Scenario: SC01. Check the search request retrieve the correct number of issues from the database.
    Given the next issues already created in the system for the owner 'test'
      | state   | title    | url            |
      | open    | Issue 1  | www.test.com   |
      | closed  | Issue 2  | www.google.com |
    When the user requests all the issues in the system
    Then it should be returned this list of issues with '2' elements

  Scenario: SC02. Check the search request retrieve all the issues with unique id from the database.
    Given the next issues already created in the system for the owner 'test'
      | state   | title    | url            |
      | open    | Issue 1  | www.test.com   |
      | closed  | Issue 2  | www.google.com |
    When the user requests all the issues in the system
    Then it should be returned this list of issues with not empty id

  Scenario: SC03. Check the search request retrieve all issues from the database.
    Given the next issues already created in the system for the owner 'test'
      | state   | title    | url            |
      | open    | Issue 1  | www.test.com   |
      | closed  | Issue 2  | www.google.com |
    When the user requests all the issues in the system
    Then it should be returned this list of issues with all the elemets unlocked

