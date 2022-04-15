package com.myi.utils;

import com.myi.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {

    public static String captureBase64Screenshot(){
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
