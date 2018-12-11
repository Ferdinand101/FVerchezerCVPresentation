package com.ferdinand.next.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HelperBase {
    public HomePage(WebDriver wd) {
        super(wd);
    }



    public void clickOnGoToEnglishVersionArea() {
        click(By.xpath("//area[@href='https://www.next.co.il/en']"));
    }

    public void clickOnGoToHebrewVersionArea() {
        click(By.cssSelector("area[href='../he']"));
    }

    public String getPageTitle(){
        return wd.findElement(By.cssSelector("h1")).getText();
    }
}
