package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class SplashScreen extends AbstractDeviceView {
    public void waitGone(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, TestConstants.TestData.LOADING_TIMEOUT);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Locators.SplashScreen.LOADING_INDICATOR)));

    }
}
