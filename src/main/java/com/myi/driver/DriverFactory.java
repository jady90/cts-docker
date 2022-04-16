package com.myi.driver;

import com.myi.constants.FrameworkConstant;
import com.myi.enums.ConfigProperties;
import com.myi.utils.PropertyUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;
        if(browser.equalsIgnoreCase("chrome")){
            if(PropertyUtils.getConfigValue(ConfigProperties.RUNMODE)
                    .equalsIgnoreCase("remote")){
                MutableCapabilities cap = new ChromeOptions();
                //cap.setBrowserName(BrowserType.CHROME);
                driver = new RemoteWebDriver(new URL("http://192.168.2.17:4444/wd/hub"), cap);
            }
            else{
                System.setProperty("webdriver.chrome.driver", FrameworkConstant.getChromeDriverPath());
                driver = new ChromeDriver();
            }
        }
        else if(browser.equalsIgnoreCase("edge")){
            if(PropertyUtils.getConfigValue(ConfigProperties.RUNMODE)
                    .equalsIgnoreCase("remote")){
                //DesiredCapabilities cap = new DesiredCapabilities();
                //cap.setBrowserName(BrowserType.EDGE);
                MutableCapabilities cap = new EdgeOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.2.17:4444/wd/hub"), cap);
            }
            else{
                System.setProperty("webdriver.edge.driver", FrameworkConstant.getEdgeDriverPath());
                driver = new EdgeDriver();
            }
        }
        else if (browser.equalsIgnoreCase("firefox")){
            if(PropertyUtils.getConfigValue(ConfigProperties.RUNMODE)
                    .equalsIgnoreCase("remote")){
               // DesiredCapabilities cap = new DesiredCapabilities();
                //cap.setBrowserName(BrowserType.FIREFOX);
                MutableCapabilities cap = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            }
            else{
                //no local firefox browser installed
            }
        }
        return driver;
    }
}
