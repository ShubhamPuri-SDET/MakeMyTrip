package com.flight.tests;

import com.flight.pages.MakeMyTripHomePage;
import com.flight.pages.FlightSearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {
    private WebDriver driver;
    private MakeMyTripHomePage homePage;
    private FlightSearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        homePage = new MakeMyTripHomePage(driver);
        searchResultsPage = new FlightSearchResultsPage(driver);
    }

    @Test
    public void testFlightSearch() {
        homePage.navigateToHomePage();
        homePage.selectFromCity("Mumbai");
        homePage.selectToCity("Delhi");
        homePage.selectDepartureDate();
        homePage.clickSearch();

        assertTrue(searchResultsPage.isFlightListDisplayed(), "Flight search results should be displayed");
        assertFalse(searchResultsPage.getAvailableAirlines().isEmpty(), "Airlines list should not be empty");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}