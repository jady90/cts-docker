package com.myi.listeners;

import com.myi.enums.ConfigProperties;
import com.myi.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public final class RetryFailedTests implements IRetryAnalyzer {
    private int count = 0;
    private int maxLimit = 1;
    @Override
    public boolean retry(ITestResult result) {
        if(PropertyUtils.getConfigValue(ConfigProperties.RETRYFAILEDTESTS)
                .equalsIgnoreCase("yes")){
            if(count <maxLimit){
                count++;
                return true;
            }
        }
        return false;
    }
}
