package com.qa.automationtesting.pages.demoApplitools;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplitoolLoginPage extends baseTestPage {

    WebDriver driver;

    public ApplitoolLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // page locators
    private By username = By.id("username");
    private By password = By.id("password");
    private By signInBtn = By.id("log-in");

    public TransactionPage loginToApplitoolsValidCreds(String user,String pwd){
       openApplitoolUrl();
       enterInput(username,user);
       enterInput(password,pwd);
       clickElement(signInBtn);

        WaitHelpers.waitJVM(5000);

        return new TransactionPage(driver);
    }

}
