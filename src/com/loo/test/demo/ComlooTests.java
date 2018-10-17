package com.loo.test.demo;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComlooTests implements SeleniumWebTestCase {

    private WebDriver driver;

    public ComlooTests() {
        // Optional, if not specified, WebDriver will search your path for chromedriver
        System.setProperty("webdriver.chrome.driver", "/home/oem/Workspace/yy/tests/selenium-package/chromedriver");

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();
    }

    private WebDriverWait await(int time) {
        return new WebDriverWait(this.driver, time);
    }

    @Override
    public void apply() {

        // 模拟登录
        driver.get("http://testk12wx.100.com/system/mockLogin?uid=1688588557&username=jack&role=3");
        // 访问主页
        driver.get("http://tests.100.com");

        // 自动重定向到/User
        await(2).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().toLowerCase().endsWith("/User");
            }
        });

        // title
        await(2).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().equals("100教育");
            }
        });

        // Close the browser
        driver.quit();
    }
}
