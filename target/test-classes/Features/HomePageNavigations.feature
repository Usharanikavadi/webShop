Feature: Test links in the homepage

  Scenario: Verify visible links in the homepage
    Given user is on homepage
    When clicks and verifying all the visible links in homepage
    And clicks on search button
    Then accepts the pop-up
    And enters search text
