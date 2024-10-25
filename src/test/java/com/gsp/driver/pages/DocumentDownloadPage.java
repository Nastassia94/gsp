package com.gsp.driver.pages;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DocumentDownloadPage {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDocumentPage() throws InterruptedException {
        // Открыть страницу
        driver.get("https://staging.gsp.agsr.by/procedures/document/cc6a2268-e51a-428f-8af6-243e2b43f085/upload");

        // Проверка заголовка
        WebElement titleElement = driver.findElement(By.xpath("//div[@id='root']//form//div[contains(@class, 'dataBlock__title')][1]"));
        String expectedTitle = "Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений";
        String actualTitle = titleElement.getText();
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает!");

        // Проверка номера административной процедуры
        WebElement procedureNumberElement = driver.findElement(By.xpath("//div[contains(text(), 'Номер административной процедуры:')]/following-sibling::div"));
        String expectedProcedureNumber = "548.3.2.4";
        String actualProcedureNumber = procedureNumberElement.getText();
        Assertions.assertEquals(expectedProcedureNumber, actualProcedureNumber, "Номер административной процедуры не совпадает!");

        // Устанавливаем чекбоксы для шести элементов
        for (int i = 1; i <= 6; i++) {
            String checkboxXPath = "//*[@id='root']/div/div[2]/form/div/div[1]/div[3]/div[2]/div[2]/div[" + i + "]/input"; // Измените на фактический XPath для каждого чекбокса
            WebElement checkbox = driver.findElement(By.xpath(checkboxXPath));
            if (!checkbox.isSelected()) {
                checkbox.click(); // Устанавливаем чекбокс, если он не выбран
            }
            Assertions.assertTrue(checkbox.isSelected(), "Чекбокс " + i + " не был установлен");
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}