package com.ferdinand.next.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSiteTest extends TestBase{
    @Test
    public void openSiteEnglishVersionFromHebrewPage(){
        app.getNavigationHelper().openSite("https://www.next.co.il/he");
        //click on English link
        app.getHomePage().clickOnGoToEnglishVersionArea();
        String MyAccountText = app.getHeader().waitAndGetMyAccountText();

        Assert.assertEquals(MyAccountText, "My Account");
    }
    @Test
    public void openSiteHebrewVersionFromEnglishPage(){
        app.getNavigationHelper().openSite("https://www.next.co.il/en");
        //click on Hebrew link
        app.getHomePage().clickOnGoToHebrewVersionArea();
        String MyAccountText = app.getHeader().waitAndGetMyAccountText();

        Assert.assertEquals(MyAccountText, "החשבון שלי");
    }
    @Test
    public void openSiteHebrewVersionFromEnglishPageByFlagIcon(){
        app.getNavigationHelper().openSite("https://www.next.co.il/en");
        //click on Flag on header
        app.getHeader().clickOnFlag();

        app.getHeader().clickOnEnHebrewButtonInTheFlag();

        String MyAccountText = app.getHeader().waitAndGetMyAccountText();
        Assert.assertEquals(MyAccountText, "החשבון שלי");
    }
    @Test
    public void openSiteEnglishVersionFromHebrewPageByFlagIcon(){
        app.getNavigationHelper().openSite("https://www.next.co.il/he");
        //click on Flag on header
        app.getHeader().clickOnFlag();

        app.getHeader().clickOnEnEnglishButtonInTheFlag();

        String MyAccountText = app.getHeader().waitAndGetMyAccountText();
        Assert.assertEquals(MyAccountText, "My Account");
    }
}
