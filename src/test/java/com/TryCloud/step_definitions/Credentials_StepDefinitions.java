package com.TryCloud.step_definitions;

import com.TryCloud.pages.LoginPage;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
}
