package com.myi.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){
        dr.set(driver);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void unloadDriver(){
        dr.remove();
    }
}
