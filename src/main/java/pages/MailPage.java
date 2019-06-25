package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    private static final String pageURL = "https://gmail.com";
    private static final Logger logger = Logger.getLogger(MailPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@role='button' and @gh='cm']")
    private WebElement createNewLetterButton;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement recipientEmailField;

    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectLetterField;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textLetterField;

    @FindBy(xpath = "//div[@role='button' and contains(@data-tooltip,'Enter')]")
    private WebElement sendLetterButton;

    @FindBy(xpath = "//a[contains(@href,'sent')]")
    private WebElement sentButton;

    @FindBy(xpath = "//a[contains(@href,'inbox') and @tabindex='-1' and @draggable='false']")
    private WebElement inboxButton;

    @FindBy(xpath = "//div[@gh='tl']//tbody/tr[@class='zA yO'][1]")
    private WebElement lastSentLetter;

    @FindBy(xpath = "//a[contains(@href, 'SignOut')]")
    private WebElement userProfileButton;

    @FindBy(xpath = "//a[contains(@href, 'Logout')]")
    private WebElement logoutButton;

    private By newLetterButtonLocator = By.xpath("//div[@role='button' and @gh='cm']");
    private By newLetterWindowLocator = By.xpath("//textarea[@name='to']");
    private By letterSentLocator = By.xpath("//span[@class='aT']");
    private By sentOpenedLocator = By.xpath("//div[@class='BltHke nH oy8Mbf' and @style='' and @role='main']");
    private By userProfileOpenedLocator = By.xpath("//a[contains(@href, 'Logout')]");
    private By passwordFieldLocator = By.xpath("//input[@type='password']");

    public MailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void open() {
        driver.get(pageURL);
        wait.withMessage("Страница не загрузилась")
                .until(ExpectedConditions.visibilityOfElementLocated(newLetterButtonLocator));
    }

    public void createNewLetter() {
        createNewLetterButton.click();
        wait.withMessage("Не удалось создать письмо")
                .until(ExpectedConditions.visibilityOfElementLocated(newLetterWindowLocator));
        logger.info("Новое письмо открыто");
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
        wait.withMessage("Не удалось отправить письмо")
                .until(ExpectedConditions.visibilityOfElementLocated(letterSentLocator));
        logger.info("Письмо отправлено");
    }

    public void verifyLastSentLetter(String recipientEmail, String letterSubject, String letterText) {
        sentButton.click();
        wait.withMessage("Не удалось перейти в \"Отправленные\"")
                .until(ExpectedConditions.visibilityOfElementLocated(sentOpenedLocator));
        wait.withMessage("Письмо не добавлено в \"Отправленные\"")
                .until(ExpectedConditions.not(ExpectedConditions.textToBe( By.xpath(".//span[@class='bog']/span"),
                        letterSubject)));
        logger.info("Письмо добавленно в отправленные");
        logger.info("Тема отправленного письма сохранена корректно");
        String lastSentLetterRecipientEmail = driver.findElement(By.xpath(".//div[@class='yW']/span[@email]"))
                .getAttribute("email");
        String lastSentLetterText = lastSentLetter.findElement(By.xpath(".//span[@class='y2']")).getText().substring(4);
        if(lastSentLetterRecipientEmail.equals(recipientEmail)) {
            logger.info("Адресат отправленного письма сохранен корректно");
        } else {
            logger.error("Адресат отправленного письма сохранен некорректно");
        }
        if(letterText.contains(lastSentLetterText)) {
            logger.info("Текст отправленного письма сохранен корректно");
        } else {
            logger.error("Текст отправленного письма сохранен некорректно");
        }
    }

    public void logout() {
        userProfileButton.click();
        wait.withMessage("Не удалось раскрыть окно профиля")
                .until(ExpectedConditions.visibilityOfElementLocated(userProfileOpenedLocator));
        logoutButton.click();
        wait.withMessage("Не удалось выйти из аккаунта")
                .until(ExpectedConditions.visibilityOfElementLocated(passwordFieldLocator));
        logger.info("Выход из аккаунта выполнен успешно");
    }
}
