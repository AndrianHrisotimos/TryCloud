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

    @US-001_Cloud-1327
  Scenario:User can login with valid credentials hitting the "Enter" key from the keyboard as the last step
    When user enters "Employee33" username
    And  user enters "Employee123" password
    And  user hit the Enter from keyboard
    Then user should see "Dashboard - Trycloud QA" page

   @US-001_Cloud-1328
      Scenario Outline:User can not login with any invalid credentials
        When user enters wrong "<username>" and "<password>"
        Then "Wrong username or password." should be displayed for invalid credentials

        Examples: Wrong credentials
          | username   | password    |
          | Employe    | Employee123 |
          | employee   | Employee123 |
          | Employee33 | Employee    |
          | EMPLOYEE   | Employee123 |
          | Employee   | Employee    |
          | Employee33 | employee    |
          | Employee33 | Employee12  |
          | Employee   | Employee13  |
          | Employee33 | employee123 |

