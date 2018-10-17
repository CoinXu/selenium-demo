package com.loo.test.demo;

import java.net.URL;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestSelenium {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        baseUrl = "http://tests.100.com";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSelenium() throws Exception {
        driver.get("http://testk12wx.100.com/system/mockLogin?uid=1688588557&username=jack&role=3");
        driver.get(baseUrl + "/User");

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("span.label")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.linkText("课时明细")).click();
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector("img.thumb-image")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.linkText("我的订单")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.linkText("课时明细")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("img.thumb-image")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.linkText("已完成课节")).click();

        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("span.btn.primary")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
