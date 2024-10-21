package com.gsp.driver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DocumentPageTests {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Указать путь к драйверу ChromeDriver

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Открыть страницу
        driver.get("https://staging.gsp.agsr.by/procedures/document");
    }

    @Test
    public void verifyPageTitle() {
        // автотест для проверки заголовка страницы
        String expectedTitle = "Document Procedures - GSP";
        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Title does not match!";
    }

    @Test
    public void interactWithElements() {
        // XPath для взаимодействия с элементами страницы

        // Найти элемент по XPath и кликнуть на него
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchField.sendKeys("Sample document");

        // выбор кнопки поиска и клика по ней
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        // Допустим, мы проверяем результат
        WebElement result = driver.findElement(By.xpath("//div[@class='result-item']"));
        assert result.isDisplayed() : "Result is not displayed!";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}