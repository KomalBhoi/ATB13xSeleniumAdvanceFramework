package com.qa.automationtesting.testsVWO.pageObjectModelTC;

import com.qa.automationtesting.base.baseTest;
import com.qa.automationtesting.driver.DriverManager;
import com.qa.automationtesting.pages.vwo.PageObjectModel.DashboardPage;
import com.qa.automationtesting.pages.vwo.PageObjectModel.LoginPage;
import com.qa.automationtesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class vwoLoginTest extends baseTest {

    public static final Logger logger = LogManager.getLogger(vwoLoginTest.class);

    @Description("TC#1 - Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){

        logger.info("Starting the Test cases Page Object Model");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),
                PropertiesReader.readKey("invalid_password"));

        logger.info("Asserting the invalid credentials");
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_msg"));

    }

    @Description("TC#2 - Verify that valid creds dashboard page is loaded")
    @Test
    public void test_positive_vwo_login(){
        logger.info("Starting the Test cases Page Object Model");

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String userNameLoggedIn = dashboardPage.loggedInUserName();
        assertThat(userNameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Done the test cases");
        Assert.assertEquals(userNameLoggedIn,PropertiesReader.readKey("expected_username"));

    }


}
