package com.travelHub.ui;


import com.travelHub.driver.drivers.Driver;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;

public class BaseTest {
    WebDriver driver;

    @AfterEach
    public void finish() {
        Driver.quitDriver();
    }

}