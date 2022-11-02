@CLOUD-1144
  Feature: TryCloud app logout feature
    User Story :

    As a user, I should be able to log out.
  Background: For the scenarios in this feature file, user is expected to logout.
    Given  user should see "Dashboard - Trycloud QA" page after login

    @CLOUD-1438
    Scenario: User can log out and ends up in login page
      When user click on user profile settings
      And user see the dropdown settings
      And user click on logout button
      Then verify user should see "Trycloud QA"

    @CLOUD-1439
    Scenario: User can not go to home page again by clicking step back button after successfully logged out.
      When user click on user profile settings
      And user click on logout button
      Then verify user can not go back on dashboard page by clicking forward button