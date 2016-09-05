package com.applause.auto.pageframework.chunks;

import com.applause.auto.framework.pageframework.devicecontrols.BaseDeviceControl;
import com.applause.auto.pageframework.locators.Locators;

/**
 * Created by sunstream-laptop on 28.06.2015.
 */

//I am not extending Button class, as it contains a bug -- a malformed String-to-format expression:
// "Tapping Button with selector [%]."
// instead of
// "Tapping Button with selector [%s]." -- missing 's'
public class SearchButton extends BaseDeviceControl {

    public SearchButton() {
        super(Locators.RecipesSearch.SEARCH_BUTTON);
    }

    public void startSearch(){
        this.tap();
    }
}
