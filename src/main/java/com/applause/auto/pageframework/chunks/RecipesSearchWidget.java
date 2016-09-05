package com.applause.auto.pageframework.chunks;

import com.applause.auto.framework.pageframework.device.AbstractDeviceChunk;
import com.applause.auto.pageframework.locators.Locators;
import com.applause.auto.pageframework.pageInterfaces.Searchable;
import org.apache.log4j.Logger;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class RecipesSearchWidget extends AbstractDeviceChunk implements Searchable{
    private Logger logger = Logger.getLogger(RecipesSearchWidget.class);
    SearchBox searchBox;
    SearchButton searchButton;
    public RecipesSearchWidget() {
        super(Locators.RecipesSearch.SEARCH_FIELD);
    }
    public void search(String searchCriteria){
        searchBox = new SearchBox();
        searchBox.setSearchCriteria(searchCriteria);

        logger.info(String.format("Application search: Searching recipes by [%s] started.", searchCriteria));
        searchButton = new SearchButton();
        searchButton.startSearch();

        new ProgressMessage().waitFinished();
        logger.info(String.format("Application search: Searching recipes by [%s] completed.", searchCriteria));
    }
}
