package com.qa.automationtesting.pages.demoqaModalDialog;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyModalDialogContentPage extends baseTestPage {

    WebDriver driver;
    public VerifyModalDialogContentPage(WebDriver driver) {
        this.driver = driver;
    }


    private By smallModal = By.xpath("//button[@id='showSmallModal']");
    private By largeModal = By.xpath("//button[@id='showLargeModal']");
    private By clsSmallModalBtn = By.xpath("//button[@id=\"closeSmallModal\"]");
    private By clsLargeModalBtn = By.xpath("//button[@id=\"closeLargeModal\"]");

    public void clickSmallModal(){
        openModalDialogUrl();
        scrollToView();
        clickElement(smallModal);
        WaitHelpers.waitJVM(5000);
    }

    public void clickLargeModal(){
        openModalDialogUrl();
        scrollToView();
        clickElement(largeModal);
        WaitHelpers.waitJVM(5000);
    }

    public void closeSmallModalBtn(){
        clickElement(clsSmallModalBtn);
    }

    public void closeLargeModalBtn(){
        clickElement(clsLargeModalBtn);
    }
}
