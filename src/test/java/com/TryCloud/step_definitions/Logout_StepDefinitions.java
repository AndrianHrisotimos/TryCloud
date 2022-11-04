package com.TryCloud.step_definitions;

import com.TryCloud.pages.LoginPage;
import com.TryCloud.pages.LogoutPage;
import com.TryCloud.utilities.BrowserUtils;
import com.TryCloud.utilities.ConfigurationReader;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class Logout_StepDefinitions {


    LoginPage loginPage = new LoginPage();
    @Given("user should see {string} page after login")
    public void user_should_see_page_after_login(String Dashboard_page) {
        String url = ConfigurationReader.getProperty("WebTableUrl");
        Driver.getDriver().get(url);
        loginPage.login("Employee33","Employee123");
        Assert.assertTrue(Driver.getDriver().getTitle().contains(Dashboard_page));
    }

    LogoutPage logoutPage = new LogoutPage();
    @When("user click on user profile settings")
    public void user_click_on_user_profile_settings() {
        logoutPage.userProfileSettings.click();
    }
    @When("user see the dropdown settings")
    public void user_see_the_dropdown_settings() {
        List<String> dropdownOptions = BrowserUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//nav[@id='expanddiv']")));

        for (String each : dropdownOptions) {
            System.out.println(each);
        }



    }
    @When("user click on logout button")
    public void user_click_on_logout_button() {
        logoutPage.logoutButton.click();
    }
    @Then("verify user should see {string}")
    public void verify_user_should_see(String loginPage) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(loginPage));
    }

    @Then("verify user can not go back on dashboard page by clicking back button")
    public void verify_user_can_not_go_back_on_dashboard_page_by_clicking_back_button() {

        Driver.getDriver().navigate().back();

        BrowserUtils.verifyTitle("Trycloud QA");
    }
}
