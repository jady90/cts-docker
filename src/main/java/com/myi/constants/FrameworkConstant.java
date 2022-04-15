package com.myi.constants;

import com.myi.enums.ConfigProperties;
import com.myi.utils.PropertyUtils;

public final class FrameworkConstant {

    private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") +
            "/src/test/java/com/myi/resources/chromedriver.exe";
    private static final String EDGEDRIVERPATH = System.getProperty("user.dir") +
            "/src/test/java/com/myi/resources/msedgedriver.exe";
    /*private static final String CONFIGFILEPATH = System.getProperty("user.dir") +
            "/src/test/java/com/myi/resources/config.properties";
    private static final String EXCELDATAFILEPATH = System.getProperty("user.dir") +
            "/src/test/java/com/myi/resources/exceltestdata.xlsx";*/
    private static final String CONFIGFILEPATH = "config.properties";
    private static final String EXCELDATAFILEPATH = "exceltestdata.xlsx";
    private static final String EXCELRUNNERSHEETNAME = "runner";
    private static final String EXCELDATASHEETNAME = "data";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") +
            "/extent-test-output/";
    private static String extentReportFilePath = "";
    private static final int EXPLICITWAITTIME = 20;


    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getEdgeDriverPath() {
        return EDGEDRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    public static String getExcelDataFilePath() {
        return EXCELDATAFILEPATH;
    }

    public static String getExcelRunnerSheetName() {
        return EXCELRUNNERSHEETNAME;
    }

    public static String getExcelDataSheetName() {
        return EXCELDATASHEETNAME;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = generateExtentReportFilePath();
            return extentReportFilePath;
        }
        return extentReportFilePath;
    }

    private static String generateExtentReportFilePath(){
        if (PropertyUtils.getConfigValue(ConfigProperties.OVERRIDEREPORTS)
                .equalsIgnoreCase("yes")) {
            return EXTENTREPORTFOLDERPATH + "index.html";
        } else {
            return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
        }
    }

    public static int getExplicitWaitTime(){
        return EXPLICITWAITTIME;
    }
}
