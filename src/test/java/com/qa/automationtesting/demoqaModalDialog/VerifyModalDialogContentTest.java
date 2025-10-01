package com.qa.automationtesting.demoqaModalDialog;

import com.qa.automationtesting.base.baseTest;
import com.qa.automationtesting.driver.DriverManager;
import com.qa.automationtesting.pages.demoqaModalDialog.VerifyModalDialogContentPage;
import com.qa.automationtesting.utils.WaitHelpers;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.automationtesting.driver.DriverManager.driver;

public class VerifyModalDialogContentTest extends baseTest {

    VerifyModalDialogContentPage verifyModalDialog;

    @Description("TC#1 - Verify the modal content")
    @Test
    public void test_verifyModalContent(){
        verifyModalDialog = new VerifyModalDialogContentPage(DriverManager.getDriver());
        //Verify the content of small modal
        verifyModalDialog.clickSmallModal();
        verifySmallModalContent();
        verifyModalDialog.closeSmallModalBtn();

        //Verify the content of large modal
        verifyModalDialog.clickLargeModal();
        verifyLargeModalContent();
        verifyModalDialog.closeLargeModalBtn();
    }

    public void verifySmallModalContent(){
        WebElement container = WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//div[@class='modal-content']")));
        String actualContentValue = container.findElement(By.cssSelector("div.modal-body")).getText();

        Assert.assertEquals(actualContentValue,"This is a small modal. It has very less content");
    }

    public void verifyLargeModalContent(){
        WebElement container = WaitHelpers.visibilityOfElement(driver.findElement(By.xpath("//div[@class='modal-content']")));
        WebElement contentElement = container.findElement(By.xpath(".//div[@class='modal-body']/p[last()]"));
        String fullContent = contentElement.getText();

        String targetPhrase = "Lorem Ipsum";
        Assert.assertTrue(fullContent.contains(targetPhrase));
    }
}
