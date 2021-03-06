Feature: Initiate chat with a known person

  In order to initiate chat with a friend
  I want a feature where I am able to login to
  my account and then chat with that friend as usual

  Background:
    Given I start Kik and choose to login
    When I log into my account
    Then I should be shown the list of people that I chat with

  @helloKik
  Scenario: Registered user is logged in and initiates chat with a friend
    Given I tap on the name of the person to talk with
    When I send her some message
