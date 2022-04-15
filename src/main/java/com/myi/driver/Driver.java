package com.myi.driver;

import com.myi.enums.ConfigProperties;
import com.myi.exceptions.BrowserInvocationFailedException;
import com.myi.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    public static void initDriver(String browser){
        if(Objects.isNull(DriverManager.getDriver())){
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Pls check browser capabilities");
            }
        }
        DriverManager.getDriver().get(PropertyUtils.getConfigValue(ConfigProperties.URL));
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }

    }
}
