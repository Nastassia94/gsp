package com.gsp.driver.pages;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        Assertions.assertEquals(expectedTitle, actualTitle, "Получение аттестата соответствия юридического лица, индивидуального предпринимателя, осуществляющего отдельные виды архитектурной, градостроительной, строительной деятельности (их составляющие), выполнение работ по обследованию зданий и сооружений");

        // Проверка номера административной процедуры
        WebElement procedureNumberElement = driver.findElement(By.xpath("//div[contains(text(), 'Номер административной процедуры:')]/following-sibling::div"));
        String expectedProcedureNumber = "548.3.2.4";
        String actualProcedureNumber = procedureNumberElement.getText();
        Assertions.assertEquals(expectedProcedureNumber, actualProcedureNumber, "Номер административной процедуры не совпадает!");

        // Устанавливаем чекбоксы для шести элементов
//        for (int i = 1; i <= 6; i++) {
//            String checkboxXPath = "//*[@id='root']/div/div[2]/form/div/div[1]/div[3]/div[2]/div[2]/div[" + i + "]/input"; // Измените на фактический XPath для каждого чекбокса
//            WebElement checkbox = driver.findElement(By.xpath(checkboxXPath));
//            if (!checkbox.isSelected()) {
//                checkbox.click(); // Устанавливаем чекбокс, если он не выбран
//            }
//            Assertions.assertTrue(checkbox.isSelected(), "Чекбокс " + i + " не был установлен");
//        }
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/form/div/div[1]/div[3]/div[2]/div[2]/div[1]/input"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox1);
        Thread.sleep(500);
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Assertions.assertTrue(checkbox1.isSelected(), "Чекбокс 1 не был установлен");

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"информация о наличии находящихся в собственности, хозяйственном ведении, оперативном управлении средств измерения и контроля, необходимых для контроля качества выполняемых работ по обследованию зданий и сооружений, при осуществлении деятельности по инженерным изысканиям для объектов строительства первого–четвертого классов сложности_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox2);
        Thread.sleep(500);
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assertions.assertTrue(checkbox2.isSelected(), "Чекбокс 2 не был установлен");

        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"документ, подтверждающий внесение платы за услуги (за исключением случаев внесения платы посредством платежной системы в едином расчетном и информационном пространстве)_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox3);
        Thread.sleep(500);
        if (!checkbox3.isSelected()) {
            checkbox3.click();
        }
        Assertions.assertTrue(checkbox3.isSelected(), "Чекбокс 3 не был установлен");

        WebElement checkbox4 = driver.findElement(By.xpath("//*[@id=\"документ, подтверждающий внесение платы за услуги (за исключением случаев внесения платы посредством платежной системы в едином расчетном и информационном пространстве)_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox4);
        Thread.sleep(500);
        if (!checkbox4.isSelected()) {
            checkbox4.click();
        }
        Assertions.assertTrue(checkbox4.isSelected(), "Чекбокс 4 не был установлен");

        WebElement checkbox5 = driver.findElement(By.xpath("//*[@id=\"(по форме согласно приложению)заявление о получении аттестата соответствия_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox5);
        Thread.sleep(500);
        if (!checkbox5.isSelected()) {
            checkbox5.click();
        }
        Assertions.assertTrue(checkbox5.isSelected(), "Чекбокс 5 не был установлен");

        WebElement checkbox6 = driver.findElement(By.xpath("//*[@id=\"(должны соответствовать требованиям определенным в пункте 7 Положения)копии свидетельств о технической компетентности системы производственного контроля_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox6);
        Thread.sleep(500);
        if (!checkbox6.isSelected()) {
            checkbox6.click();
        }
        Assertions.assertTrue(checkbox6.isSelected(), "Чекбокс 7 не был установлен");
        WebElement checkbox7 = driver.findElement(By.xpath("//*[@id=\"(должны соответствовать требованиям определенным в абзаце четвертом части второй пункта 6 и в пункте 7 Положения)сведения о составе и профессиональной квалификации руководящих работников, специалистов и рабочих, работающих по основному месту работы, в том числе копии документов, подтверждающих данные сведения_isNotProvided\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox7);
        Thread.sleep(500);
        if (!checkbox6.isSelected()) {
            checkbox6.click();
        }
        Assertions.assertTrue(checkbox6.isSelected(), "Чекбокс 6 не был установлен");

        // Находим и кликаем на кнопку загрузки
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div/div[5]/div[2]/div[2]/div[1]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton); // Скроллим к кнопке загрузки
        Thread.sleep(500);
        uploadButton.click();

//        // Находим поле для загрузки файла
//        WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"(должны соответствовать требованиям определенным в абзаце четвертом части второй пункта 6 и в пункте 7 Положения)сведения о составе и профессиональной квалификации руководящих работников, специалистов и рабочих, работающих по основному месту работы, в том числе копии документов, подтверждающих данные сведения_isNotProvided\"]"));
//        String filePath = "C:/path/to/your/file.pdf";
//        fileInput.sendKeys(filePath);

        // Модальное окно, ввод наименования документа
        System.out.println("Ввод наименования документа в модальном окне");
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"description\"]"));
        String documentName = "Тестовый документ";
        nameInput.sendKeys(documentName);

        // Клик на кнопку "Прикрепите файл" и загрузка документа
        WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        String filePath = "C:\\Users\\Nastassia\\Downloads\\Заявление(2).docx";
        Thread.sleep(1000);
        uploadInput.sendKeys(filePath);
        System.out.println("Файл успешно выбран для загрузки");

        // Проверка успешной загрузки
        System.out.println("Проверка успешной загрузки файла");
        WebElement uploadSuccessMessage = driver.findElement(By.xpath("//*[contains(text(), 'Карточка документа успешно созданна')]"));
        Assertions.assertTrue(uploadSuccessMessage.isDisplayed(), "Файл не был загружен успешно");

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}