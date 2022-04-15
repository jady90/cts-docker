package com.myi.listeners;

import com.myi.annotations.FrameworkAnnotation;
import com.myi.reports.ExtentLogger;
import com.myi.reports.ExtentReport;
import com.myi.testutils.ElkUtils;
import org.testng.*;

public final class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
        ElkUtils.resetElkData();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).author());
        ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.passFinalStep(result.getMethod().getMethodName() + " is passed", true);
        ElkUtils.sendDetailsToElk(result.getMethod().getMethodName(), "pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
        ExtentLogger.fail(result.getThrowable().toString());
        ElkUtils.sendDetailsToElk(result.getMethod().getMethodName(), "fail");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
