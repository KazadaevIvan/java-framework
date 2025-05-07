package ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleUITests {
    WebDriver driver;

    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void openSiteTest() {
        driver.get(BASE_URL);
    }

    @Test
    void openWebFromPageTest() {
        driver.get(BASE_URL);

        driver.findElement(By.xpath("//a[@href='web-form.html']")).click();

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView;", submitButton);

        WebElement title = driver.findElement(By.className("display-6"));

        Assertions.assertEquals("Form submitted", title.getText());
    }
}
