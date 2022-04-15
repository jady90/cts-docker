package com.myi.tests;

import com.myi.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    @BeforeMethod
    protected void setup(Object[] data){
        Map<String, String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void teardown(){
        Driver.quitDriver();
    }

}
