package com.flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FlightSearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "airways-name")
    private List<WebElement> airlineNames;

    @FindBy(className = "actual-price")
    private List<WebElement> flightPrices;

    @FindBy(className = "viewFareBtn")
    private List<WebElement> viewFareButtons;

    public FlightSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isFlightListDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(airlineNames)).size() > 0;
    }

    public void selectFirstFlight() {
        if (!viewFareButtons.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(viewFareButtons.get(0))).click();
        }
    }

    public List<String> getAvailableAirlines() {
        wait.until(ExpectedConditions.visibilityOfAllElements(airlineNames));
        return airlineNames.stream()
                .map(WebElement::getText)
                .collect(java.util.stream.Collectors.toList());
    }
}