package com.gsp.driver.pages;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewStatementPageTest {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testNewStatementCreation() throws InterruptedException {
        driver.get("https://staging.gsp.agsr.by/statements");

        WebElement newStatementButton = driver.findElement(By.xpath("//button[@class='btn edit btn-medium button__pencil']"));
        newStatementButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='modal__title']/div[contains(., 'Новое заявление')]")));

        // Поле "Номер АП" - выбор из выпадающего списка
        WebElement apNumberField = driver.findElement(By.xpath("//div[@class='reversed__value-container css-hlgwow']"));
        apNumberField.click();
        Thread.sleep(5000);
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='reversed__single-value css-1dimb5e-singleValue'][@class='reversed__single-value css-1dimb5e-singleValue']")));
        option.click();


        // Поле "Код пакета"
        WebElement packageCodeInput = driver.findElement(By.id("packageNumber"));
        packageCodeInput.sendKeys("6e889bb2-e2a8-46bd-a230-3a8465f837c9");

        // Поле "УНП заинтересованного лица"
        WebElement unpInput = driver.findElement(By.id("unpNumber"));
        unpInput.sendKeys("400237155");

        //Кнопка "Сохранить"
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(@class, 'save-button')]//span"));
        saveButton.click();
    }
    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
