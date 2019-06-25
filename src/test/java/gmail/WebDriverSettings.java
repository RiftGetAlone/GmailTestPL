package gmail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class WebDriverSettings {
    protected WebDriver driver = WebDriverManager.initChromeDriver();

    @Before
    public void initWebDriver() {
        driver.manage().window().maximize();
    }

    @After
    public void closeWebDriver() {
        driver.close();
    }
}