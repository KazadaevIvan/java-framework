package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class SimpleUITests extends BaseTest {

    public static final String VALID_USER = testConfig.getLogin();
    public static final String VALID_PASSWORD = testConfig.getPassword();

    @Test
    @DisplayName("Open site test")
    void openSiteTest() {
        driver.get(BASE_URL);
    }

    @Test
    @DisplayName("Open web form test")
    void openWebFormPageTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(BASE_URL);

        driver.findElement(By.xpath("//a[@href='web-form.html']")).click();

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", submitButton);

        wait.until(ExpectedConditions.urlContains("submitted-form.html"));
        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }

    @Test
    @DisplayName("Login test")
    void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(VALID_USER, VALID_PASSWORD);

        Assertions.assertEquals("Login successful", loginPage.getSuccessAlertText());
    }
}
