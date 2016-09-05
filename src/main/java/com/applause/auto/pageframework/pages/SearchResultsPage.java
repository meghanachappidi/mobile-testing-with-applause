package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.framework.pageframework.devicecontrols.Text;
import com.applause.auto.pageframework.chunks.RecipesSearchWidget;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.pageInterfaces.Searchable;
import com.applause.auto.pageframework.testdata.TestConstants;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class SearchResultsPage extends AbstractDeviceView {
    private Logger logger = Logger.getLogger(SearchResultsPage.class);
    Searchable searchWidget = new RecipesSearchWidget();
    Text searchResultsCountText;

    public void search(String searchCriteria) {
        searchWidget.search(TestConstants.TestData.SEARCH_CRITERIA_FOR_MULTIPLE_MATCHES);
    }

    public void verifySearchResultsListContainsMultipleResults(){
        logger.info("Verify: Multiple search results should be available in the list.");
        List<WebElement> searchResults = driver.findElementsById(Locators.SearchResults.SEARCH_RESULTS_ITEM_TITLE);
        Assert.assertTrue(searchResults.size() > 1, "Multiple search results listed:");
    }

    public void verifySearchResultsCountInSubHeaderIsMoreThanOne(){
        logger.info("Verify: Search results number should be displayed on Search Results page.");
        searchResultsCountText = new Text(Locators.SearchResults.SEARCH_RESULTS_COUNT);
        String searchResultsCountStr = searchResultsCountText.getStringValue();
        int count;
        try {
            count = Integer.parseInt(searchResultsCountStr.trim());
        } catch (NumberFormatException e) {
            throw new AssertionError("Cannot verify search results count: "+searchResultsCountStr+" is not a number.");
        }
        Assert.assertTrue(count > 1, "Search Results page sub-header contains some number of results, which is > 1.");
    }


}
