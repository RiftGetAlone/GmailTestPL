package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;


public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String pageURL = "https://accounts.google.com";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "identifierId")
    private WebElement loginField;

    @FindBy(id = "identifierNext")
    private WebElement inputLoginButton;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "passwordNext")
    private WebElement inputPasswordButton;

    private By loginFieldLocator = By.id("identifierId");
    private By passwordFieldLocator = By.name("password");

    public void open() {
        driver.get(pageURL);
        wait.withMessage("Страница не загрузилась")
                .until(ExpectedConditions.visibilityOfElementLocated(loginFieldLocator));
    }

    public void writeLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputLogin() {
        inputLoginButton.click();
        wait.withMessage("Неверный логин").until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
    }

    public void writePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void inputPassword() {
        inputPasswordButton.click();
        wait.withMessage("Неверный пароль")
                .until(ExpectedConditions.urlContains("https://myaccount.google.com"));
    }
}
