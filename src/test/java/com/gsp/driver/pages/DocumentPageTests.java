package com.gsp.driver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentPageTests {

    static WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Открыть страницу
        driver.get("https://staging.gsp.agsr.by/procedures/document");
        WebElement authButton = driver.findElement(By.xpath("//button[span[text()='Войти']]"));
        authButton.click();

        // Поля для ввода email и пароля
        WebElement emailInput = driver.findElement(By.id("login"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Ввод данных
        emailInput.sendKeys("ggse");
        passwordInput.sendKeys("11036085Ok");

        // Отправка лонина  пароля
        passwordInput.submit(); // Или так  driver.findElement(By.id("submitButtonId")).click();

        // Страница загружается
        Thread.sleep(5000); // Посмотреть может лучше заюзать WebDriverWait
    }

    @Test
    public void verifyPageTitle() {
        // Поиск элемента заголовка
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/h2"));

        // Проверка, что заголовок совпадает
        String expectedTitle = "Административные процедуры";
        String actualTitle = titleElement.getText();

        assertEquals("Административные процедуры", expectedTitle, actualTitle);
    }

    @Test
    public void interactWithElements() throws InterruptedException {

        // Находим ээлемент и кликаем на него
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/input"));
        searchField.sendKeys("Получение аттестата соответствия");
        Thread.sleep(5000);


        // проверяем результат
        WebElement result = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/table/tbody/tr[6]/td[3]"));
        Thread.sleep(5000);
        assert result.isDisplayed() : "Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений";
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

