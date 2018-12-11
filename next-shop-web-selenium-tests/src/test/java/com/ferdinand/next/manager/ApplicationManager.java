package com.ferdinand.next.manager;


import com.ferdinand.next.tests.Listener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  public HomePage homePage;
  EventFiringWebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private String browser;
  private Header header;
  private SearchResultPage searchResultPage;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public Header getHeader() {
    return header;
  }

  public void start() {

    if(browser.equals(BrowserType.CHROME)){
    wd = new EventFiringWebDriver(new ChromeDriver());
    }
    else if(browser.equals(BrowserType.FIREFOX)){
      wd = new EventFiringWebDriver(new FirefoxDriver());
    }else if(browser.equals(BrowserType.IE)){
      wd = new EventFiringWebDriver(new InternetExplorerDriver());
    }
    wd.register(new Listener());
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    navigationHelper = new NavigationHelper(wd);
    header = new Header(wd);
    searchResultPage = new SearchResultPage(wd);

    navigationHelper.openSite("https://www.next.co.il/he");

   homePage = new HomePage(wd);
  }

  public HomePage getHomePage() {
    return homePage;
  }

  public void stop() {
    wd.quit();
  }

  //__________________________________________________________________


  public SearchResultPage getSearchResultPage() {
    return searchResultPage;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }


  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
