package com.ferdinand.next.tests;


import com.ferdinand.next.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
   //comment

  protected static ApplicationManager app =
           new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  Logger logger = LoggerFactory.getLogger(TestBase.class);


  @BeforeSuite
  public void setUp(){
    app.start();
  }
  //@AfterSuite
  //public  void tearDown(){
    //app.stop();
  //}

  @BeforeMethod(alwaysRun = true)
  public void startLog(Method m){
    logger.info("Start test method " + m.getName());
  }
  @AfterMethod(alwaysRun = true)
  public void stopLog(Method m){
    logger.info("Stop test method " + m.getName());
  }


}
