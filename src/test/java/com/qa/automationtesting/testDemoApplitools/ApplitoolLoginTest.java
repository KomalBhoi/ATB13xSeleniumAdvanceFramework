package com.qa.automationtesting.testDemoApplitools;

import com.qa.automationtesting.base.baseTest;
import com.qa.automationtesting.driver.DriverManager;
import com.qa.automationtesting.pages.demoApplitools.ApplitoolLoginPage;
import com.qa.automationtesting.pages.demoApplitools.TransactionPage;
import com.qa.automationtesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplitoolLoginTest extends baseTest {


    @Description("TC#1 - Login to DemoApplitool using valid credentials")
    @Test
    public void test_demoApplitools_validLogin(){

        // Login demoApplitools url with valid credentials
        ApplitoolLoginPage loginPage = new ApplitoolLoginPage(DriverManager.getDriver());
        loginPage.loginToApplitoolsValidCreds(PropertiesReader.readKey("userNm_applitools"),
                PropertiesReader.readKey("pwd_applitools"));

        // Verify that after login, page redirected to the next page or not
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        //System.out.println(currentUrl);
        Assert.assertEquals(currentUrl,"https://demo.applitools.com/app.html");

        TransactionPage transactionPage = new TransactionPage(DriverManager.getDriver());
        String logoLabel = transactionPage.loggedInSuccess();
        //System.out.println(logoLabel);
        Assert.assertEquals(logoLabel,"ACME");

//        System.out.println(transactionPage.getAmount());
    }
}
