package com.applause.auto.pageframework.chunks;

import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class ProgressMessage extends Text {
    private Logger logger = Logger.getLogger(ProgressMessage.class);
    private WebDriverWait wait = new WebDriverWait(this.getDriver(), TestConstants.TestData.LOADING_TIMEOUT);

    public ProgressMessage() {
        super(Locators.General.PROGRESS_POP_UP);
    }
    
    public void waitFinished() {
        waitProgressMessageAppear();
        waitProgressMessageGone();
    }

    private void waitProgressMessageAppear(){
        this.logger.info("Progress message appears on the screen.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Locators.General.PROGRESS_POP_UP)));
    }

    private void waitProgressMessageGone(){
        this.logger.info("Progress message is gone.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Locators.General.PROGRESS_POP_UP)));
    }
}
