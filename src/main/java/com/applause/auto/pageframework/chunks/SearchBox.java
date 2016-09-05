package com.applause.auto.pageframework.chunks;

import com.applause.auto.framework.pageframework.devicecontrols.TextBox;
import com.applause.auto.pageframework.locators.Locators;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class SearchBox extends TextBox {

    public SearchBox() {
        super(Locators.RecipesSearch.SEARCH_FIELD);
    }

    public void setSearchCriteria(String searchCriteria){
        this.enterText(searchCriteria);
    }
}
