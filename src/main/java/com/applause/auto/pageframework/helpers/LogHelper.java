package com.applause.auto.pageframework.helpers;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by sunstream-laptop on 29.06.2015.
 */
public class LogHelper {
    private Logger logger = Logger.getLogger(LogHelper.class);
    public void saveScreenshotOnFailure(WebDriver driver, ITestResult testResult){
        if (driver != null) {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(testResult.getTestContext().getOutputDirectory() + screenshotFile.getName());
            String testName = (testResult != null && testResult.getTestName() != null) ? testResult.getTestName() : "[unknown test]";
            try {
                FileUtils.copyFile(screenshotFile, destinationFile);
                logger.info("Screenshot on '" +testName + "' failure: " + screenshotFile.getAbsolutePath());
            } catch (IOException e) {
                logger.info("Failed to save a screenshot on '"+testName+"' failure: "+e.getMessage());
            }
        } else {
            logger.info("Cannot get screenshot: driver is null.");
        }
    }
}
