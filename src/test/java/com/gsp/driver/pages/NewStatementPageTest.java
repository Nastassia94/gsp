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
    public void testNewStatementCreation() {

        WebElement newStatementButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/button"));
        newStatementButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Создание нового заявления')]")));

        // Поле "Номер АП" - выбор из выпадающего списка
        WebElement apNumberDropdown = driver.findElement(By.xpath("//div[contains(@class, 'dropdown')]//div[@role='combobox']"));
        Select apNumberSelect = new Select(apNumberDropdown);
        apNumberSelect.selectByVisibleText("548.3.2.4");

        // Поле "Код пакета" - ввод текста
        WebElement packageCodeInput = driver.findElement(By.id("packageNumber"));
        packageCodeInput.sendKeys("6e889bb2-e2a8-46bd-a230-3a8465f837c9");

        // Поле "УНП заинтересованного лица" - ввод текста
        WebElement unpInput = driver.findElement(By.id("unpNumber"));
        unpInput.sendKeys("400237155");

        // Клик по кнопке "Сохранить"
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(@class, 'save-button')]//span"));
        saveButton.click();
    }
}
