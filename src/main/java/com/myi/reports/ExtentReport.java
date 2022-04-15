package com.myi.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myi.constants.FrameworkConstant;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static void initReport(){
        if(Objects.isNull(extentReports)){
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter
                    (FrameworkConstant.getExtentReportFilePath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setDocumentTitle("Automation Test");
            extentSparkReporter.config().setReportName("MyInsurance Automation Test Execution");
            extentSparkReporter.config().setTheme(Theme.STANDARD);
        }
    }

    public static void createTest(String testcasename){
        extentTest = extentReports.createTest(testcasename);
        ExtentManager.setExtentTest(extentTest);
    }

    public static void flushReport(){
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
            ExtentManager.unloadExtentTest();
        }
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addAuthor(String[] authors){
        for(String author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategory(String[] categories){
        for(String category : categories){
            ExtentManager.getExtentTest().assignCategory(category);
        }
    }
}
