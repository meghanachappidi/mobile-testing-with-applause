package com.applause.auto.test;

import com.applause.auto.framework.test.BaseAppiumTest;
import com.applause.auto.pageframework.helpers.LogHelper;
import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.pages.SplashScreen;
import com.applause.auto.pageframework.pages.SearchResultsPage;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class WholeFoodsSearchTest extends BaseAppiumTest {

    private LogHelper logHelper = new LogHelper();;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

	@BeforeClass(alwaysRun = true)
	public void testSetup() throws MalformedURLException {
        SplashScreen splashScreen = PageFactory.initElements(driver, SplashScreen.class);
        splashScreen.waitGone();
    }

	@Test(description = "User searches for recipes using existing value and gets multiple matches.")
	public void verify_recipes_search_returns_multiple_results() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.search(TestConstants.TestData.SEARCH_CRITERIA_FOR_MULTIPLE_MATCHES);

        searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        searchResultsPage.verifySearchResultsCountInSubHeaderIsMoreThanOne();
        searchResultsPage.verifySearchResultsListContainsMultipleResults();
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        logHelper.saveScreenshotOnFailure(driver, testResult);
        super.onTestFailure(testResult);
    }
}
