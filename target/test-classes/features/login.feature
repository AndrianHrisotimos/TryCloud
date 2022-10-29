Feature:TryCloud app login feature
  User Story :

  As a user, I should be able to login so that I can land on the dashboard page.
  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user can go to "https://qa.trycloud.net/"

    @US-001_Cloud-1306
    Scenario:User can login with valid credentials clicking on the "Login button"
      When user enters "Employee33" username
      And  user enters "Employee123" password
      And  user click on login button
      Then user should see "Dashboard - Trycloud QA" page