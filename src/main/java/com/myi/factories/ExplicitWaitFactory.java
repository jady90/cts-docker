package com.myi.factories;

import com.myi.constants.FrameworkConstant;
import com.myi.driver.DriverManager;
import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public final class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by){
        WebElement element = null;
        if(waitStrategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstant
                    .getExplicitWaitTime())).until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitStrategy == WaitStrategy.PRESENT){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstant
                    .getExplicitWaitTime())).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitStrategy == WaitStrategy.VISIBLE){
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstant
                    .getExplicitWaitTime())).until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitStrategy == WaitStrategy.NONE){
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }



}
