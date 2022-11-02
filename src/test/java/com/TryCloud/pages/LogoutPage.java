package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@id=\"user\"]")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id=\"submit-form\"]")
    public WebElement LoginButton;

    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        LoginButton.click();
    }

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement userProfileSettings;

    @FindBy(xpath = "//nav[@id='expanddiv']")
    public WebElement DropdownOptions;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;
}
