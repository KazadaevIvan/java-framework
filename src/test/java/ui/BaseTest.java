package ui;

import config.TestConfig;
import driver.DriverSingleton;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@ExtendWith(AfterTestExtension.class)
public class BaseTest {
    WebDriver driver;
    static TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterAll()
    static void tearDown() {
        DriverSingleton.closeDriver();
    }
}
