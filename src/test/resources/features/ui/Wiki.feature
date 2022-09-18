@wiki
Feature: Wiki Feature

  Scenario: Wiki Page Heading
    When User is on Wikipedia
    Then Page heading should say Wikipedia

  Scenario: Wiki Search bar
    When User is on Wikipedia
    Then Wiki search bar should be visible