package com.qa.automationtesting.base;

import com.qa.automationtesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.automationtesting.driver.DriverManager.getDriver;

public class baseTestPage {

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void clickElement(By by){
       getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }
}
