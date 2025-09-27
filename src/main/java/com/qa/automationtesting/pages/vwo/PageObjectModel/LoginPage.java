package com.qa.automationtesting.pages.vwo.PageObjectModel;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.automationtesting.driver.DriverManager.getDriver;

public class LoginPage extends baseTestPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Step 1 - Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInBtn = By.id("js-login-btn");
    private By error_msg = By.id("js-notification-box-msg");

    public String loginToVWOLoginInvalidCreds(String user, String pwd){
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signInBtn);
        WaitHelpers.checkVisibility(getDriver(),error_msg);
        return getText(error_msg);
    }

    public void loginToVWOLoginValidCreds(String user, String pwd){
        openVWOUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signInBtn);

        //Wait - Thread Sleep
        WaitHelpers.waitJVM(5000);
    }
}
