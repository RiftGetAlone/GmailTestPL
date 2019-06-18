package gmail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class WebDriverSettings {

    protected WebDriver driver;

    @Before
    public void initWebDriver() {
        driver = WebDriverManager.initFirefoxDriver();
    }

    @After
    public void closeWebDriver() {
        driver.quit();
    }
}
