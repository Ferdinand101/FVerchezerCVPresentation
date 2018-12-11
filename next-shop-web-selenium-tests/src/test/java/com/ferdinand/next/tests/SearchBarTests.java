package com.ferdinand.next.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBarTests extends TestBase {
    @Test
    public void searchBarTest(){
        app.getNavigationHelper().openSite("https://www.next.co.il/en");
        app.getHeader().typeInSearchBar("Shoes");
        app.getHeader().proceedToSearch();

        String pageTitle = app.getSearchResultPage().getPageTitle();
        Assert.assertEquals(pageTitle, "FOOTWEAR");
    }
}
