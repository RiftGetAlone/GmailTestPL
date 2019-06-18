package pages;

import org.openqa.selenium.WebDriver;

public class MailPage {
    private WebDriver driver;
    private static final String pageURL = "https://gmail.com";

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

}
