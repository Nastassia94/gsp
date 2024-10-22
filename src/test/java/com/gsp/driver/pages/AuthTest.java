package com.gsp.driver.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AuthTest {
    public void login() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Открываем сайт
            driver.get("https://staging.gsp.agsr.by/");

            // Устанавливаем неявное ожидание
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

            // Проверяем, что авторизация прошла успешно
            if (driver.getPageSource().contains("Вы успешно вошли в систему")) {
                System.out.println("Авторизация прошла успешно.");
            } else {
                System.out.println("Неправильный логин или пароль.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрываем браузер
            driver.quit();
        }
    }
    }

