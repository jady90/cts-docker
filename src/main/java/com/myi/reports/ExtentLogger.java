package com.myi.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.myi.enums.ConfigProperties;
import com.myi.utils.PropertyUtils;
import com.myi.utils.ScreenshotUtils;

public final class ExtentLogger {

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded){
        if(PropertyUtils.getConfigValue(ConfigProperties.PASSEDSTEPSCREENSHOTS)
                .equalsIgnoreCase("yes") && isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.captureBase64Screenshot()).build());
        }
        else{
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenshotNeeded){
        if(PropertyUtils.getConfigValue(ConfigProperties.FAILEDSTEPSCREENSHOTS)
                .equalsIgnoreCase("yes") && isScreenshotNeeded){
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.captureBase64Screenshot()).build());

        }
        else{
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenshotNeeded){
        if(PropertyUtils.getConfigValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS)
                .equalsIgnoreCase("yes") && isScreenshotNeeded){
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.captureBase64Screenshot()).build());
        }
        else{
            skip(message);
        }
    }

    public static void passFinalStep(String message, boolean isScreenshotNeeded){
        if(isScreenshotNeeded){
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (ScreenshotUtils.captureBase64Screenshot()).build());
        }
    }

}
