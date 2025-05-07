package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(id = "success")
    private WebElement successAlert;

    public static final String VALID_USER = "user";
    public static final String VALID_PASSWORD = "user";

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL + "login-form.html");
    }

    public void login() {
        usernameInput.sendKeys(VALID_USER);
        passwordInput.sendKeys(VALID_PASSWORD);
        loginButton.click();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}
