package com.myi.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

     static void setExtentTest(ExtentTest test){
        exTest.set(test);
    }

     static ExtentTest getExtentTest(){
        return exTest.get();
    }

     static void unloadExtentTest(){
        exTest.remove();
    }
}
