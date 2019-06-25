package gmail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MailPage;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailTest extends WebDriverSettings {

    @Test
    public void logIn() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        String emailSender = "";
        String passwordSender = "";

        loginPage.open();
        loginPage.writeLogin(emailSender);
        loginPage.inputLogin();
        loginPage.writePassword(passwordSender);
        loginPage.inputPassword();
    }

    @Test
    public void sendLetter() {
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        UUID uuid = UUID.randomUUID();
        String emailRecipient = "";
        String letterSubject = uuid.toString();
        String letterText = "";

        logIn();
        mailPage.open();
        mailPage.createNewLetter();
        mailPage.writeRecipientEmail(emailRecipient);
        mailPage.writeLetterSubject(letterSubject);
        mailPage.writeLetterText(letterText);
        mailPage.sendLetter();
        mailPage.verifyLastSentLetter(emailRecipient, letterSubject, letterText);
        mailPage.logout();
    }
}
