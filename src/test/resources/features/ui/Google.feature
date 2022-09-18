@google
Feature: Google Feature

  Scenario: Google Search Bar
    When User is on Google
    Then Search bar should be visible

  Scenario: Google Search
    When User is on Google
    And User types "Test Automation" in the search bar
    And User clicks search icon
    Then Search Result should load