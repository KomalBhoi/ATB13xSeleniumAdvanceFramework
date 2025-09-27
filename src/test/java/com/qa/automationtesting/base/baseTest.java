package com.qa.automationtesting.base;

import com.qa.automationtesting.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class baseTest {

    @BeforeTest
    public void setUp() {
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.tearDown();
    }
}
