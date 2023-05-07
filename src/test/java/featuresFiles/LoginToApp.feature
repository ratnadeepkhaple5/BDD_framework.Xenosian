Feature: login to homepage

  Scenario: able to login to app with valid credintials
    Given enter username and password
    Then click on submit
    Then verify homepage title
