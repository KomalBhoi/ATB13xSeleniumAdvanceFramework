package com.qa.automationtesting.demoqa;

import com.qa.automationtesting.base.baseTest;
import com.qa.automationtesting.driver.DriverManager;
import com.qa.automationtesting.pages.demoqa.AddRowInWebTablePage;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRowInWebTableTest extends baseTest {

    private static final Logger logger = LogManager.getLogger(AddRowInWebTableTest.class);
    AddRowInWebTablePage addRowInWebTbl;

    @Description("TC#1 - Click on 3rd edit icon")
    @Test(priority=1)
    public void test_click3rdEditIcon(){

        logger.info("Test cases started..");
        addRowInWebTbl = new AddRowInWebTablePage(DriverManager.getDriver());
        addRowInWebTbl.clickOnThirdEditBtn();

        logger.info("clicked on 3rd edit icon");
    }

    @Description("TC#2 - Add new row and verify it.")
    @Test(priority=2)
    public void test_addNewRow(){
        addRowInWebTbl = new AddRowInWebTablePage(DriverManager.getDriver());
        addRowInWebTbl.clickOnAddBtn("Komal","Bhoi","komal111@gmail.com","38",
                "100000","IT");
        //addRowInWebTbl.test_verifyNewRow("Komal");
        Assert.assertTrue(addRowInWebTbl.test_verifyNewRow("Komal"));
    }
}
