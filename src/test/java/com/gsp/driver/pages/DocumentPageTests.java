package com.gsp.driver.pages;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class DocumentPageTests {

    static WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
        Thread.sleep(5000); // Посмотреть может лучше заюзать WebDriverWait типа такого WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/h2"));

        // Проверка, что заголовок совпадает
        String expectedTitle = "Административные процедуры";
        String actualTitle = titleElement.getText();

        assertEquals("Административные процедуры", expectedTitle, actualTitle);
    }


    @Test
    @Order(1)
    public void interactWithElements() throws InterruptedException {

        // Находим ээлемент и кликаем на него
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[1]/div[1]/div[2]/input"));
        searchField.sendKeys("Получение аттестата соответствия");
        Thread.sleep(3000);

        // проверяем результат
        WebElement result = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[3]/table/tbody/tr/td[3]"));
        Thread.sleep(3000);
        assert result.isDisplayed() : "Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений";
        // Клик по кнопке просмотра
        WebElement button = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[3]/table/tbody/tr/td[4]/div/div"));
        button.click();
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div"));
        String expectedTitle = "Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений";
        String actualTitle = titleElement.getText();

        assertEquals("Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений", expectedTitle, actualTitle);
    }
    @Test
    @Order(2)
    public void scrollToAndClickPrepareDocumentsButton() throws InterruptedException {
        // Находим кнопку
        WebElement prepareDocumentsButton = driver.findElement(By.xpath("//button[span[text()='Перейти к подготовке документов']]"));

        // Сначала прокручиваем страницу до самого низа
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000); // Пауза для завершения прокрутки и отрисовки элементов

        // Выполняем окончательную прокрутку прямо к кнопке
        js.executeScript("arguments[0].scrollIntoView(true);", prepareDocumentsButton);
        Thread.sleep(1000);

        // Проверка, что кнопка видна, и кликаем на неё
        assertTrue("Кнопка 'Перейти к подготовке документов' не отображается", prepareDocumentsButton.isDisplayed());
        prepareDocumentsButton.click();

        // Проверка, что URL изменился
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("staging.gsp.agsr.by/procedures/document/cc6a2268-e51a-428f-8af6-243e2b43f085/upload"));

        // Проверка, что перешли на нужную страницу
        String expectedUrl = "https://staging.gsp.agsr.by/procedures/document/cc6a2268-e51a-428f-8af6-243e2b43f085/upload";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("https://staging.gsp.agsr.by/procedures/document/cc6a2268-e51a-428f-8af6-243e2b43f085/upload", expectedUrl, actualUrl);

        // Проверка заголовка страницы
        WebElement titleElement = driver.findElement(By.xpath("//div[@id='root']//form//div[contains(@class, 'dataBlock__title')][1]"));
        assertTrue("Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений", titleElement.isDisplayed());

        // Проверка наличия поля загрузки документов
        WebElement uploadField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div[1]/div[2]"));
        assertTrue("Поле загрузки документов отсутствует на странице", uploadField.isDisplayed());

        // Проверка наличия кнопки загрузки
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div/div[1]/div[3]/div[2]/div[1]/button/span"));
        assertTrue("Кнопка 'Загрузить' отсутствует на странице", uploadButton.isDisplayed());
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

