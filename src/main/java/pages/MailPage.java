package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String pageURL = "https://gmail.com";

    public MailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//div[@role='button' and @gh='cm']")
    private WebElement createNewLetterButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recipientEmailField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectLetterField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textLetterField;

    @FindBy(xpath = "//div[@role='button' and contains(@data-tooltip,'Ctrl')]")
    private WebElement sendLetterButton;

    private By newLetterButtonLocator = By.xpath("//div[@role='button' and @gh='cm']");
    private By newLetterWindowLocator = By.xpath("//div[@role='dialog']");

    public void open() {
        driver.get(pageURL);
        wait.withMessage("Страница не загрузилась")
                .until(ExpectedConditions.visibilityOfElementLocated(newLetterButtonLocator));
    }

    public void createNewLetter() {
        createNewLetterButton.click();
        wait.withMessage("Не удалось создать письмо")
                .until(ExpectedConditions.visibilityOfElementLocated(newLetterWindowLocator));
    }

    public void writeRecipientEmail(String recipientEmail) {
        recipientEmailField.sendKeys(recipientEmail);
    }

    public void writeLetterSubject(String letterSubject) {
        subjectLetterField.sendKeys(letterSubject);
    }

    public void writeLetterText(String letterText) {
        textLetterField.sendKeys(letterText);
    }

    public void sendLetter() {
        sendLetterButton.click();
    }
}
