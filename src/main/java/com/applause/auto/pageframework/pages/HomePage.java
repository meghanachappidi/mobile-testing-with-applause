package com.applause.auto.pageframework.pages;

import com.applause.auto.framework.pageframework.device.AbstractDeviceView;
import com.applause.auto.pageframework.chunks.RecipesSearchWidget;
import com.applause.auto.pageframework.pageInterfaces.Searchable;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */
public class HomePage extends AbstractDeviceView implements Searchable {
    Searchable searchWidget = new RecipesSearchWidget();

    public void search(String searchCriteria) {
        searchWidget.search(searchCriteria);
    }


}
