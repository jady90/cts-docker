package com.myi.pages;

import com.myi.driver.DriverManager;
import com.myi.enums.WaitStrategy;
import com.myi.factories.ExplicitWaitFactory;
import com.myi.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
        ExtentLogger.pass(elementName + " is clicked", true);
    }
    protected void sendKeys(By by, WaitStrategy waitStrategy, String value, String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
        ExtentLogger.pass(value + " entered in " + elementName, true);
    }
    protected void selectByValue(By by, WaitStrategy waitStrategy, String value, String elementName){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        Select select = new Select(element);
        select.selectByValue(value);
        ExtentLogger.pass(value + " selected from " + elementName, true);
    }
    protected boolean isDisplayed(By by, WaitStrategy waitStrategy, String elementName){
        if(ExplicitWaitFactory.performExplicitWait(waitStrategy, by).isDisplayed()) {
            ExtentLogger.pass(elementName + " is displayed on the page", true);
            return true;
        }
        else{
            ExtentLogger.fail(elementName + " not displayed", true);
            return false;
        }
    }
    public String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected int getListSize(By by){
        return DriverManager.getDriver().findElements(by).size();
    }
    protected List<WebElement> getElementsList(By by){
        return DriverManager.getDriver().findElements(by);
    }
    protected void clearValueFromTextField(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).clear();
    }
    protected boolean goToFrame(By by){
        int frameSize = getListSize(By.tagName("iframe"));
        System.out.println(frameSize);
        for(int i=0; i<frameSize; i++){
            DriverManager.getDriver().switchTo().frame(i);{
                if(DriverManager.getDriver().findElements(by).size() >0){
                    return true;
                }
                DriverManager.getDriver().switchTo().defaultContent();
            }
        }
        return false;
    }
}
