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

public class Credentials_StepDefinitions {
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

}
