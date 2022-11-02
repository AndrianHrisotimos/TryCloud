package com.TryCloud.step_definitions;

import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {
    @Given("user can go to {string}")
    public void user_can_go_to(String string) {
        String url = ConfigurationReader.getProperty("WebTableUrl");
        Driver.getDriver().get(url);

    }

    LoginPage loginPage = new LoginPage();

    @When("user enters {string} username")
    public void user_enters_username(String string) {
        loginPage.inputUsername.sendKeys(string);
    }
    @When("user enters {string} password")
    public void user_enters_password(String string) {
        loginPage.inputPassword.sendKeys(string);
    }
    @When("user click on login button")
    public void user_click_on_login_button() {
        loginPage.LoginButton.click();
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String Dashboard_page) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(Dashboard_page));
    }

    @When("user hit the Enter from keyboard")
    public void user_hit_the_enter_from_keyboard() {
       loginPage.LoginButton.sendKeys(Keys.ENTER);
    }

    @When("user enters wrong {string} and {string}")
    public void user_enters_wrong_and(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("{string} should be displayed for invalid credentials")
    public void should_be_displayed_for_invalid_credentials(String string) {
        BrowserUtils.verifyElementDisplayed(loginPage.warningMessage);
    }

    @Then("{string} message should be displayed if the password or username is empty")
    public void message_should_be_displayed_if_the_password_or_username_is_empty(String string) {
       loginPage.inputUsername.getAttribute("validationMessage");
    }

    @When("{string} is typed")
    public void is_typed(String password) {
        loginPage.inputPassword.sendKeys(password);
    }
    @Then("{string} is in a form of dots by default")
    public void is_in_a_form_of_dots_by_default(String password) {
        Assert.assertTrue("Password type is password",password.contains("password"));
    }

    @Then("user should click on the viewIcon to see the {string}")
    public void user_should_click_on_the_view_icon_to_see_the(String password) {
    loginPage.viewIcon.click();

        String passwordType = loginPage.inputPassword.getAttribute("type");

        if (passwordType.contains("text")){
            System.out.println(password + " is visible");
        }else {
            System.out.println(password + " is not visible");
        }

    }


    @When("user can  see the Forgot password? link")
    public void user_can_see_the_link() {
        loginPage.ForgotPasswordLink.isDisplayed();
        loginPage.ForgotPasswordLink.click();
    }
    @Then("user can see the {string} button after clicking {string}")
    public void user_can_see_the_button_after_clicking(String string, String string2) {

        BrowserUtils.switchToWindow("Trycloud QA");
        loginPage.ResetPasswordButton.isDisplayed();
    }


    @Given("user verify can see valid placeholders on {string} and {string}")
    public void user_verify_can_see_valid_placeholders_on_and(String string, String string2) {
        loginPage.inputUsername.getAttribute("placeholder");
        loginPage.inputPassword.getAttribute("placeholder");


        Assert.assertTrue(loginPage.inputUsername.getAttribute("placeholder").contains("Username or email"));
        Assert.assertTrue(loginPage.inputPassword.getAttribute("placeholder").contains("Password"));

    }







}
