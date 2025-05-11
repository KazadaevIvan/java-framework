package pages;

import io.qameta.allure.Step;
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

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL + "login-form.html");
    }

    @Step("Login with username '{username}' and password '{password}'")
    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Get Success Alert text")
    public String getSuccessAlertText() {
        return successAlert.getText();
    }
}
