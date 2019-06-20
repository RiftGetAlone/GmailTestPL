package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public  class WebDriverManager {
    private static final String defaultChromeDriverPath = "src\\main\\resources\\drivers\\chromedriver.exe";

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", defaultChromeDriverPath);
        return new ChromeDriver();
    }

    public static WebDriver initChromeDriver(String browserPath) {
        System.setProperty("webdriver.chrome.driver", defaultChromeDriverPath);
        return  new ChromeDriver(new ChromeOptions().setBinary(browserPath));
    }

    public static WebDriver initChromeDriver(String browserPath, String webDriverPath) {
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        return  new ChromeDriver(new ChromeOptions().setBinary(browserPath));
    }
}
