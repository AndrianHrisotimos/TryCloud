package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
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

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement viewIcon;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement ForgotPasswordLink;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement ResetPasswordButton;



    

    
}
