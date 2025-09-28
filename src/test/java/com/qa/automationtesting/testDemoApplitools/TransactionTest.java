package com.qa.automationtesting.testDemoApplitools;

import com.qa.automationtesting.base.baseTest;
import com.qa.automationtesting.driver.DriverManager;
import com.qa.automationtesting.pages.demoApplitools.ApplitoolLoginPage;
import com.qa.automationtesting.pages.demoApplitools.TransactionPage;
import com.qa.automationtesting.utils.PropertiesReader;
import com.qa.automationtesting.utils.parseAmount;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.qa.automationtesting.driver.DriverManager.driver;
import static com.qa.automationtesting.driver.DriverManager.init;

public class TransactionTest extends baseTest {
    ApplitoolLoginPage loginPage;
    TransactionPage transactionPage;
    parseAmount amount;

    @BeforeMethod
    public void setUp() {
        init();
        loginPage = new ApplitoolLoginPage(driver);
        transactionPage = new TransactionPage(driver);
        amount = new parseAmount();
        transactionPage = loginPage.loginToApplitoolsValidCreds(PropertiesReader.readKey("userNm_applitools"),
                PropertiesReader.readKey("pwd__applitools"));
    }

    @Description("TC#1 - Calculate the total amount")
    @Test(priority = 1)
    public void test_calculateTotalAmount(){
        double totalEarnedAmount = 0.0;
        double totalSpentAmount = 0.0;
        double totalAmount = 0.0;
        TransactionPage transPage = new TransactionPage(DriverManager.getDriver());
        List<WebElement> earnedAmt = driver.findElements(By.xpath("//span[@class='text-success']"));
        List<WebElement> spentAmt = driver.findElements(By.xpath("//span[@class='text-danger']"));
        for(WebElement e:earnedAmt){
            totalEarnedAmount = totalEarnedAmount + amount.parseAmount(e.getText().toString());

        }

        for(WebElement e:spentAmt){
            totalSpentAmount = totalSpentAmount + amount.parseAmount(e.getText().toString());
        }

        totalAmount = totalEarnedAmount - totalSpentAmount;
        System.out.println("Total Amount is: " +String.format("%.2f",totalAmount));
    }

    @AfterMethod
    public void tearDown(){ DriverManager.tearDown(); }
}
