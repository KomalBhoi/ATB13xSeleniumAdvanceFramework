package com.qa.automationtesting.pages.demoApplitools;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage extends baseTestPage {

    WebDriver driver;

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoLabelTransactionPage = By.xpath("//div[@class='logo-label']");
    private By amount = By.xpath("//span[@class='text-success']");

    public String loggedInSuccess(){
        WaitHelpers.visibilityOfElement(logoLabelTransactionPage);
        return getText(logoLabelTransactionPage);
    }

    public String getAmount(){
        return getText(amount);
    }
}
