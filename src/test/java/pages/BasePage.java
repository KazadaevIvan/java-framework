package pages;

import config.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    static TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    protected static final String BASE_URL = testConfig.getBaseUrl();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
