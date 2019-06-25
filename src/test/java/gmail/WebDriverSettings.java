package gmail;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class WebDriverSettings {
    protected WebDriver driver = WebDriverManager.initChromeDriver();

    @After
    public void closeWebDriver() {
        driver.close();
    }
}