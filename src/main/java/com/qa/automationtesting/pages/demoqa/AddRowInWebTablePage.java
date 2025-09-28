package com.qa.automationtesting.pages.demoqa;

import com.qa.automationtesting.base.baseTestPage;
import com.qa.automationtesting.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRowInWebTablePage extends baseTestPage {

    WebDriver driver;

    public AddRowInWebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    //page locators
    private By editIcon = By.xpath("//div[@class='action-buttons']/span[@id='edit-record-3']");
    //WebElement editIconView = driver.findElement(By.xpath("//div[@class='action-buttons']/span[@id='edit-record-3']"));
    private By addBtn = By.xpath("//button[@id='addNewRecordButton']");
    private By editCloseBtn = By.xpath("//button[@class='close']");
    private By firstNmInput = By.xpath("//input[@id='firstName']");
    private By lastNmInput = By.xpath("//input[@id='lastName']");
    private By emailInput = By.xpath("//input[@id='userEmail']"); //userEmail
    private By ageInput = By.xpath("//input[@id='age']");
    private By salaryInput = By.xpath("//input[@id='salary']");
    private By deptInput = By.xpath("//input[@id='department']");
    private By submitBtn = By.xpath("//button[@id='submit']");

    public void clickOnThirdEditBtn(){
        opendemoqaUrl();
        scrollToView();
        clickElement(editIcon);
        WaitHelpers.waitJVM(2000);

        clickElement(editCloseBtn);
        WaitHelpers.waitJVM(5000);
    }

    public void clickOnAddBtn(String fnm,String lstnm,String email,String age,String salary, String dept){
        opendemoqaUrl();
        clickElement(addBtn);
        enterInput(firstNmInput,fnm);
        enterInput(lastNmInput,lstnm);
        enterInput(emailInput,email);
        enterInput(ageInput,age);
        enterInput(salaryInput,salary);
        enterInput(deptInput,dept);
        clickElement(submitBtn);

        WaitHelpers.waitJVM(7000);
    }

    public boolean test_verifyNewRow(String name){
        //WebElement webTable = driver.findElement(By.xpath("//div[@class='rt-tr-group']"));
        int rowCount = driver.findElements(By.xpath("//div[@class='rt-tr-group']")).size();
        int colCount = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']")).size();
        boolean flag = false;

        //System.out.println("Row Count: " +rowCount);
        //System.out.println("Column Count: "+colCount);

        for(int i=1;i<rowCount;i++){
            for(int j=1;j<=colCount;j++){
                String actValue = driver.findElement(By.xpath("//div[@class='rt-table']/div[@class='rt-tbody']/div[@class='rt-tr-group']" +
                        "["+(i+1)+"]/div/div[@role='gridcell']["+j+"]")).getText();
                if(actValue.equals(name)){
                    flag = true;
                    //System.out.println(name);
                    break;
                }
            }
        }
        if(flag){
            return true;
        }
        return flag;
    }
}
