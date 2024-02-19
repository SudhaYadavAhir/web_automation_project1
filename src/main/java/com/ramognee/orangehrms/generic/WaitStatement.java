package com.ramognee.orangehrms.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitStatement {

    public static void staticWaitForSeconds(long sec)
    {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void explicitWaitForVisibilityOfElement(WebDriver driver, int sec, WebElement ele)
    {
        new WebDriverWait(driver,sec).until(ExpectedConditions.visibilityOf(ele));
    }

    public static void implicitWaitForSec(WebDriver driver, int sec){
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void explicitWaitForElementToBeClickable(WebDriver driver, int sec, WebElement ele)
    {
        new WebDriverWait(driver,sec).until(ExpectedConditions.elementToBeClickable(ele));
    }

}
