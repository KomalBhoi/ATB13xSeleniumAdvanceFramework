package com.qa.automationtesting.pages.vwo.PageObjectModel;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends baseTestPage {

    WebDriver driver;
    public DashboardPage(WebDriver driver) {
        this.driver =driver;
    }

    private By userNameOnDashboard = By.xpath("//h6");

    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }
}
