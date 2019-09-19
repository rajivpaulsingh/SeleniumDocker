package com.searchmodule.tests;

import com.newtours.pages.FlightConfirmationPage;
import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest {

    private WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        //set path
        System.setProperty("webdriver.chrome.driver", "/Users/singh2_rajiv/Automation/Selenium/Drivers/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void search() throws InterruptedException{
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch("java");
        searchPage.goToVideos();
        searchPage.getResult();
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}
