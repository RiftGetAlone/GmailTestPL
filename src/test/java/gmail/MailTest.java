package gmail;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;


public class MailTest extends WebDriverSettings {
    @Test
    public void logIn() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        String email = "email";
        String password = "password";

        loginPage.open();
        loginPage.writeLogin(email);
        loginPage.inputLogin();
        loginPage.writePassword(password);
        loginPage.inputPassword();
    }

}
