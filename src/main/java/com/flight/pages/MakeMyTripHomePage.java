package com.flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MakeMyTripHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(xpath = "//span[text()='Departure']")
    private WebElement departureDate;

    @FindBy(xpath = "//a[text()='Search']")
    private WebElement searchButton;

    @FindBy(className = "primaryBtn")
    private WebElement searchFlightsButton;

    public MakeMyTripHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get("https://www.makemytrip.com/");
    }

    public void selectFromCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(fromCity)).click();
        // Add logic to select city from dropdown
    }

    public void selectToCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(toCity)).click();
        // Add logic to select city from dropdown
    }

    public void selectDepartureDate() {
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
        // Add logic to select date
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton)).click();
    }
}